package com.willingtogohome.gymga.user.controller;

import com.willingtogohome.gymga.user.model.dto.*;
import com.willingtogohome.gymga.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/selectAll")
    public String UserAllList(Model model) {

        List<UserAndEmpDTO> userList = userService.allUser();

        for (UserAndEmpDTO user : userList) {
            System.out.println("user = " + user);
        }

        model.addAttribute("userList", userList);

        return "user/selectAll";
    }

    @GetMapping("/selectDetail")
    public void detailPage() {
    }

    @PostMapping("/selectDetail")
    public String selectDetail(@RequestParam("code") String userCode, Model model) {

        int code = Integer.parseInt(userCode);

        List<UserTotDTO> userList = userService.selectDetail(code);

        model.addAttribute("userList", userList);

        return "user/selectDetail";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("code") String userCode) {

        int code = Integer.parseInt(userCode);
        userService.deleteUser(code);

        return "redirect:/user/selectAll";
    }

    @GetMapping("/search")
    public void searchPage() {
    }

    @PostMapping("/search")
    public String userSearch(Model model, @RequestParam String search, @RequestParam String category, HttpSession session) {

        SearchCriteria criteria = new SearchCriteria();
        criteria.setText(search);
        criteria.setCondition(category);

        List<UserDTO> userList = userService.searchedUser(criteria);

        session.setAttribute("searchedUser", userList);

        model.addAttribute("userList", userList);

        for (UserDTO user : userList) {
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
    public String registPage() {

        return "user/regist";
    }

    @PostMapping("/regist")
    public String registUser(@ModelAttribute @DateTimeFormat(pattern="yyyy-MM-dd") UserDTO newUser, PhysicalDTO physical,
                             @RequestParam String userAddress1, @RequestParam String userAddress2) {

        int code = userService.findLastCode();

        newUser.setUserCode(code + 1);
        newUser.setUserRole("회원");
        newUser.setUserAddress(userAddress1 + " " + userAddress2);
        physical.setUserCode(code + 1);

        userService.registUser(newUser, physical);

        return "redirect:/user/selectAll";
    }
}
