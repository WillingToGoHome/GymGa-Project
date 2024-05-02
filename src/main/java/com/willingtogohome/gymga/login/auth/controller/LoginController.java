package com.willingtogohome.gymga.login.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String loginPage() {
        return "/login";
    }

    @GetMapping("/admin/page")
    public String adminPage(){
        return "/login/admin/admin";
    }

    @GetMapping("/user/page")
    public String userPage(){
        return "/login/user/user";
    }

    @GetMapping("/auth/fail")
    public ModelAndView loginFail(ModelAndView mv, @RequestParam String message) {

        mv.addObject("message", message);
        mv.setViewName("/login/auth/fail");

        return mv;
    }

}
