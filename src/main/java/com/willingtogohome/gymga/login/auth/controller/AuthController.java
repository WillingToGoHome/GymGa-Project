package com.willingtogohome.gymga.login.auth.controller;

import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public void login(){}

//    @GetMapping(value = "/auth/login")
//    public ModelAndView authLogin(@ModelAttribute LoginDTO loginDTO){
//        ModelAndView mv = new ModelAndView();
//
//        mv.setViewName("/login/auth/login");
//
//        return mv;
//    }
//
//    @PostMapping(value = "/auth/login")
//    public String loginPost(@ModelAttribute LoginDTO loginDTO){
//        // 사용자의 역할 확인
//        List<String> role = loginDTO.getRole(); // 예시로 사용자의 역할 정보가 LoginDTO에 role 필드로 저장되어 있다고 가정합니다.
//        System.out.println(loginDTO);
//        System.out.println(role);
//        // 사용자의 역할에 따라 리다이렉트할 페이지 결정
//        if ("ADMIN".equals(role)) { // 예시로 "ADMIN"이 관리자를 나타내는 값이라고 가정합니다.
//            return "redirect:/login/admin/page"; // 관리자 페이지로 리다이렉트
//        } else {
//            return "redirect:/login/user/page"; // 사용자 페이지로 리다이렉트
//        }
//    }

    @GetMapping("/fail")
    public ModelAndView loginFail(ModelAndView mv, @RequestParam String message) {

        mv.addObject("message", message);
        mv.setViewName("login/auth/fail");

        return mv;
    }
}
