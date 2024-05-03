package com.willingtogohome.gymga.login.auth.controller;

import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/auth/login")
    public ModelAndView authLogin(@ModelAttribute LoginDTO loginDTO){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("/login/auth/login");

        return mv;
    }

    @PostMapping(value = "/auth/login")

    @GetMapping("/admin/page")
    public String adminPage(){
        return "login/admin/admin";
    }

    @GetMapping("/user/page")
    public String userPage(){
        return "login/user/user";
    }
}
