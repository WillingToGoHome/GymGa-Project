package com.willingtogohome.gymga.user.controller;

import com.willingtogohome.gymga.user.model.dto.UserDTO;
import com.willingtogohome.gymga.user.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

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

    @GetMapping("/delete")
    public void delete() {}
    @PostMapping("/delete")
    public String deleteUser(UserDTO deleteUser) {

        userService.deleteUser(deleteUser);

        return "redirect:/user/selectAll";
    }

    @GetMapping("/search")
    public String userSearch(Model model) {

        List<UserDTO> userList = userService.searchUser();

        model.addAttribute("userList", userList);

        return "redirect:/user/selectAll";
    }
}
