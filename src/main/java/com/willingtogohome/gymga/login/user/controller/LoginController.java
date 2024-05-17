package com.willingtogohome.gymga.login.user.controller;

import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import com.willingtogohome.gymga.login.user.model.dto.RegistDTO;
import com.willingtogohome.gymga.login.user.model.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login/admin/regist")
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

    @GetMapping(value = "/login/auth/find")
    public String find(){
        return "/login/auth/find";
    }

    @RequestMapping(value = "/login/auth/find_id", method = RequestMethod.POST)
    @ResponseBody
    public String find_id(@Param("userName") String userName, @Param("userPhone") String userPhone) {
        String result = loginService.find_id(userName,userPhone);
        System.out.println(userName);
        System.out.println(userPhone);
        return result;
    }

    @RequestMapping(value = "/login/auth/find_pwd", method = RequestMethod.POST)
    @ResponseBody
    public String find_pwd(@RequestParam("userId") String userId, @RequestParam("userPhone") String userPhone) {

        String result = loginService.find_pwd(userId, userPhone);
        System.out.println(userId);
        System.out.println(userPhone);
        return  result;
    }



}
