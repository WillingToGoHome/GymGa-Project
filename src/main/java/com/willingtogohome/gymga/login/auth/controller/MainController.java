package com.willingtogohome.gymga.login.auth.controller;

import com.willingtogohome.gymga.login.auth.model.service.MainService;
import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import com.willingtogohome.gymga.login.user.model.service.LoginService;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    public final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping(value = "/login")
    public void login(){}

    @GetMapping(value = "/login/auth/fail")
    public ModelAndView loginFail(ModelAndView mv, @RequestParam String message) {

        mv.addObject("message", message);
        mv.setViewName("/login/auth/fail");

        return mv;
    }

    @GetMapping(value = "/main")
    public String main(SecurityContextHolder securityContextHolder, HttpSession session) {

        String logonCode = securityContextHolder.getContext().getAuthentication().getName();
        int code = Integer.parseInt(logonCode);

        UserDTO login = mainService.selectLoginInfo(code);

        Map<String, String> loginInfo = new HashMap<>();

        if (session.getAttribute("info") == null) {
            loginInfo.put("name", login.getUserName());
            loginInfo.put("role", login.getUserRole());
            loginInfo.put("pic", login.getUserPic());

            session.setAttribute("info", loginInfo);
        }

        return "main";
    }

    @GetMapping(value = "/main/info", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public UserDTO selectLoginInfo(SecurityContextHolder securityContextHolder) {

        String logonCode = securityContextHolder.getContext().getAuthentication().getName();
        int code = Integer.parseInt(logonCode);

        return mainService.selectLoginInfo(code);
    }
}
