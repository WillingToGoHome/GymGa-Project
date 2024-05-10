/*
package com.willingtogohome.gymga.login.user.controller;

import com.willingtogohome.gymga.login.user.model.dto.RegistDTO;
import com.willingtogohome.gymga.login.user.model.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/admin/regist")
    public String regist(){
        return "/login/admin/regist";
    }

    @PostMapping("/login/admin/regist")
    public ModelAndView regist(@ModelAttribute RegistDTO registDTO) {
        ModelAndView mv = new ModelAndView();

        int result = loginService.regist(registDTO);

        String message = "";

        if (result > 0) {
            message = "회원가입에 성공하였습니다.";
        } else {
            message = "회원가입에 실패하였습니다.";
        }
        mv.addObject("message", message);
        mv.setViewName("/login");

        return mv;
    }
}
*/
