package com.willingtogohome.gymga.login.auth.controller;

import com.willingtogohome.gymga.login.user.model.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MainController {

    @GetMapping(value = "/login")
    public void login(){}

    @GetMapping(value = "/login/auth/fail")
    public ModelAndView loginFail(ModelAndView mv, @RequestParam String message) {

        mv.addObject("message", message);
        mv.setViewName("/login/auth/fail");

        return mv;
    }

    @GetMapping(value = "/main")
    public String main(SecurityContextHolder securityContextHolder) {

        String logonName = securityContextHolder.getContext().getAuthentication().getName();

        System.out.println("logonName = " + logonName);

        return "main";
    }

}
