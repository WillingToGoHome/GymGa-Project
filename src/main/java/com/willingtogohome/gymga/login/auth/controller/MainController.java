package com.willingtogohome.gymga.login.auth.controller;

import com.willingtogohome.gymga.login.auth.model.service.AuthService;
import com.willingtogohome.gymga.login.common.UserRole;
import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.willingtogohome.gymga.login.common.UserRole.ADMIN;

@Controller
public class MainController {


    @GetMapping(value = "/login")
    public void login(){}

    @GetMapping("/login/auth/success")
    public void success(){}


//    @GetMapping("/user/user")
//    public String userPage(){
//        return "login/user/user";
//    }
//
//    @GetMapping("/admin/admin")
//    public String adminPage(){
//        return "login/admin/admin";
//    }


}
