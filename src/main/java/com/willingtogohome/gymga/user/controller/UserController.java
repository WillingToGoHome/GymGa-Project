package com.willingtogohome.gymga.user.controller;

import com.willingtogohome.gymga.user.model.dto.*;

import com.willingtogohome.gymga.user.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/selectall")
    public String UserAllList(Model model) {

        List<UserAndEmpDTO> userList = userService.allUser();

        model.addAttribute("userList", userList);

        return "user/selectall";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("code") String userCode) {


        int code = Integer.parseInt(userCode);
        userService.deleteUser(code);

        return "redirect:/user/selectall";
    }

    @GetMapping("/search")
    public void searchPage() {
    }

    @PostMapping("/search")
    public String userSearch(Model model, @RequestParam String search, @RequestParam String category, HttpSession session) {

        SearchCriteria criteria = new SearchCriteria();
        criteria.setText(search);
        criteria.setCondition(category);

        List<UserAndEmpDTO> userList = userService.searchedUser(criteria);

        session.setAttribute("searchedUser", userList);

        model.addAttribute("userList", userList);

        for (UserAndEmpDTO user : userList) {
            System.out.println("user = " + user);
        }

        return "user/search";
    }

    @GetMapping(value = "/teacher", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<UserDTO> findTeacherList() {

        userService.findAllTeacher().forEach(System.out::println);

        return userService.findAllTeacher();
    }

    @GetMapping("/regist")
    public String registPage(Model model) {

        List<UserDTO> userIDList = userService.selectAllUserID();

        String[] idList = new String[userIDList.size()];
        int i = 0;
        for (UserDTO userId : userIDList) {
            idList[i++] = userId.getUserId();
        }

        model.addAttribute("idList", idList);

        return "user/regist";
    }

    @PostMapping("/regist")
    public String registUser(HttpSession session,
                             @ModelAttribute @DateTimeFormat(pattern="yyyy-MM-dd")
                             UserDTO newUser, PhysicalDTO physical,
                             @RequestParam String userAddress1, @RequestParam String userAddress2, @RequestParam String urlAddress,
                             @RequestParam MultipartFile picFile) {

        if (!picFile.isEmpty()) {
            String root = "src/main/resources/static";
            String filePath = root + "/uploadFiles";
            File dir = new File(filePath);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String originFileName = picFile.getOriginalFilename();
            String ext = originFileName.substring(originFileName.lastIndexOf("."));
            String savedName = UUID.randomUUID() + ext;
            System.out.println("savedName = " + savedName);

            try {
                picFile.transferTo(new File(filePath + "/" + savedName));
                newUser.setUserPic(savedName);
//                session.setAttribute("/uploadFiles/" + savedName, urlAddress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            newUser.setUserPic("default-user.png");
        }

        int code = userService.findLastCode();

        if (newUser.getUserBirth() == null) {
            newUser.setUserBirth("2000-01-01");
        }

        newUser.setUserCode(code + 1);
        newUser.setUserRole("MEMBER");
        newUser.setUserAddress(userAddress1 + " " + userAddress2);
        physical.setUserCode(code + 1);
        System.out.println("newUser = " + newUser);

        userService.registUser(newUser, physical);

        return "redirect:/user/selectall";
    }

    @GetMapping("/selectdetail")
    public String selectDetail(HttpSession session,
                               @RequestParam("code") String userCode, Model model,
                               UserDTO userDTO, PhysicalDTO physicalDTO) {

        int code = Integer.parseInt(userCode);

        session.setAttribute("userCode", code);

        userDTO.setUserCode(code);
        physicalDTO.setUserCode(code);

        UserTotDTO user = userService.getUserDetailByCode(code, userDTO, physicalDTO);

        model.addAttribute("user", user);

        return "user/selectdetail";
    }

    @GetMapping("/update")
    public String updateUser(HttpSession session,
                             @RequestParam("code") String userCode, Model model,
                             UserDTO userDTO, PhysicalDTO physicalDTO) {

        int code = Integer.parseInt(userCode);

        session.setAttribute("userCode", code);

        userDTO.setUserCode(code);
        physicalDTO.setUserCode(code);

        UserTotDTO user = userService.updatePage(code, userDTO, physicalDTO);

        model.addAttribute("user", user);

        return "/user/update";
    }

    @PostMapping("/updateuser")
    public String update(HttpSession session,
                         @RequestParam("code") String userCode, Model model,
                         @RequestParam String userAddress1, @RequestParam String userAddress2,
                         @ModelAttribute @DateTimeFormat(pattern="yyyy-MM-dd")
                         UserDTO userDTO, PhysicalDTO physicalDTO,
                         @RequestParam MultipartFile picFile) {

        int code = Integer.parseInt(userCode);

        session.setAttribute("userCode", code);

        userDTO.setUserCode(code);
        physicalDTO.setUserCode(code);
        userDTO.setUserRole("MEMBER");

        if (!userAddress1.isEmpty()) {
            if (!userAddress2.isEmpty()) {
                userDTO.setUserAddress(userAddress1 + " " + userAddress2);
            } else {
                userDTO.setUserAddress(userAddress1);
            }
        } else {
            userDTO.setUserAddress("");
        }

        if (!picFile.isEmpty()) {
            String root = "src/main/resources/static";
            String filePath = root + "/uploadFiles";
            File dir = new File(filePath);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String originFileName = picFile.getOriginalFilename();
            String ext = originFileName.substring(originFileName.lastIndexOf("."));

            String savedName = UUID.randomUUID() + ext;

            try {
                picFile.transferTo(new File(filePath + "/" + savedName));
                userDTO.setUserPic(savedName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        userService.update(userDTO, physicalDTO);

        UserTotDTO user = userService.getUserDetailByCode(code, userDTO, physicalDTO);

        model.addAttribute("user", user);

        return "user/selectdetail";
    }
}
