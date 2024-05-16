package com.willingtogohome.gymga.user.pain.controller;

import com.willingtogohome.gymga.user.pain.model.dto.PainDTO;
import com.willingtogohome.gymga.user.pain.model.service.PainService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class PainController {

    private final PainService painService;

    @Autowired
    public PainController(PainService painService) { this.painService = painService; }


    @PostMapping("/pain")
    public String mainPain(HttpSession session,
                           @RequestParam("name") String userName,
                           @RequestParam("code") String userCode, Model model,
                           PainDTO painDTO) {

        int code = Integer.parseInt(userCode);

        session.setAttribute("userCode", userCode);

        painDTO.setUserCode(code);
        painDTO.setUserName(userName);

        PainDTO pain = painService.selectPain(code, userName, painDTO);

        model.addAttribute("pain", pain);

        return "user/pain/pain";
    }
}
