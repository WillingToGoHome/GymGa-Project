package com.willingtogohome.gymga.login.auth.controller;

import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.willingtogohome.gymga.login.common.UserRole.ADMIN;

@Controller
public class MainController {

    @GetMapping(value = "/login")
    public String login(){
        return "/login";
    }

    @PostMapping(value = "/login")
    public String loginPost(@ModelAttribute LoginDTO loginDTO){
        // 사용자의 역할 확인
        List<String> role = loginDTO.getRole(); // 사용자의 역할 정보가 LoginDTO에 role 필드로 저장.
        System.out.println(loginDTO);
        System.out.println(role);
        // 사용자의 역할에 따라 리다이렉트할 페이지 결정
        if (ADMIN.equals(role)) {
            return "redirect:/login/admin/admin"; // 관리자 페이지로 리다이렉트
        } else {
            return "redirect:/login/user/user"; // 사용자 페이지로 리다이렉트
        }
    }

    @GetMapping("/login/auth/fail")
    public ModelAndView loginFail(ModelAndView mv, @RequestParam String message) {

        mv.addObject("message", message);
        mv.setViewName("/login/auth/fail");
        return mv;
    }

    /*PostMapping후 권한 구분 없이 순서대로 페이지가 뜸..*/

    @GetMapping("/user/user")
    public String userPage(){
        return "login/user/user";
    }

    @GetMapping("/admin/admin")
    public String adminPage(){
        return "login/admin/admin";
    }



}
