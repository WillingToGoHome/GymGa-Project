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

@Controller
@RequestMapping("/pain")
public class PainController {

    private final PainService painService;

    @Autowired
    public PainController(PainService painService) {
        this.painService = painService;
    }

    @GetMapping("/detail")
    public void mainPain() {}

    @PostMapping("/detail")
    public String mainPain(HttpSession session,
                           @RequestParam("name") String userName,
                           @RequestParam("code") String userCode, Model model,
                           PainDTO painDTO) {

        int code = Integer.parseInt(userCode);

        session.setAttribute("userCode", code);

        painDTO.setUserCode(code);

        PainDTO pain = painService.selectPain(code, userName, painDTO);

        model.addAttribute("pain", pain);
        model.addAttribute("userName", userName);

        return "/user/pain/detail";
    }

    @GetMapping("/regist")
    public void regist() {
    }

    @PostMapping("/regist")
    public String regist(HttpSession session,
                         @RequestParam("code") int code, @RequestParam("pos") int pos,
                         PainDTO painDTO) {


        session.setAttribute("userCode", code);

        painDTO.setUserCode(code);
        painDTO.setPos(pos);

        painService.registPainCodeAndPos(painDTO);

        return "/user/pain/regist";
    }

    @GetMapping("/registPain")
    public void regitPain() {
    }

    @PostMapping("/registPain")
    public String registPain(HttpSession session,
                             @RequestParam("code") int code, @RequestParam("pos") int pos,
                             PainDTO painDTO) {


        session.setAttribute("userCode", code);

        painDTO.setUserCode(code);
        painDTO.setPos(pos);

        painService.registPain(painDTO);

        return "/user/pain/detail";
    }

    @PostMapping("/delete")
    public String deletePain(@RequestParam("deleteCode") int code, @RequestParam("deletePos") int pos) {

        painService.deletePain(code, pos);

        return "/user/pain/detail";
    }
}
