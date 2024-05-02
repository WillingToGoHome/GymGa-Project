package com.willingtogohome.gymga.login.user.model.controller;

import com.willingtogohome.gymga.login.user.model.dto.RegistDTO;
import com.willingtogohome.gymga.login.user.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/regist")
    public void regist(){}

    @PostMapping("/regist")
    public ModelAndView regist(ModelAndView mv, @ModelAttribute RegistDTO registDTO) {

        int result = userService.regist(registDTO);

        String message = "";

        if (result > 0) {
            message = "회원가입에 성공하였습니다. Gymga에서 확인 및 승인 후 이용 가능하십니다.";
        } else {
            message = "회원가입에 실패하였습니다. 관리자에게 문의해주세요.";
        }

        mv.addObject("message", message);

        return mv;
    }
}
