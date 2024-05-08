package com.willingtogohome.gymga.user.controller;

import com.willingtogohome.gymga.user.model.dto.PhysicalDTO;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import com.willingtogohome.gymga.user.model.dto.SearchCriteria;
import com.willingtogohome.gymga.user.model.dto.UserTotDTO;
import com.willingtogohome.gymga.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static java.awt.SystemColor.text;

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

        List<UserDTO> userList = userService.AllUser();

        for (UserDTO user : userList) {
            System.out.println("user = " + user);
        }

        model.addAttribute("userList", userList);

        return "user/selectAll";
    }

    @GetMapping("/selectDetail")
    public void detailPage() {}

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

        return "user/search";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @PostMapping("/regist")
    public String registUser(UserDTO newUser, PhysicalDTO physical,
                             @RequestParam String address1, @RequestParam String address2) {

        int code = userService.findLastCode();

        newUser.setCode(code + 1);
        newUser.setRole("회원");
        newUser.setAddress(address1 + " " + address2);
        physical.setCode(code + 1);

        userService.registUser(newUser, physical);

     return "redirect:/user/selectAll";
    }
}
