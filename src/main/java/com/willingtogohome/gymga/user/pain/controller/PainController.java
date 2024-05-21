package com.willingtogohome.gymga.user.pain.controller;

import com.willingtogohome.gymga.user.pain.model.dto.PainDTO;
import com.willingtogohome.gymga.user.pain.model.dto.PainUpdateDTO;
import com.willingtogohome.gymga.user.pain.model.service.PainService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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

    @PostMapping("/detail")
    public String mainPain(HttpSession session,
                           @RequestParam("code") String userCode,
                           Model model,
                           PainDTO painDTO) {

        int code = Integer.parseInt(userCode);

        PainDTO pain = painService.selectPain(code);

        model.addAttribute("pain", pain);
        model.addAttribute("code", userCode);

        System.out.println(userCode);

        return "user/pain/detail";
    }

    @GetMapping("/regist")
    public void regist() {
    }

    @PostMapping("/regist")
    public String regist(HttpSession session,
                         @RequestParam("pos") String painPos,
                         @RequestParam("code") String userCode,
                         Model model) {

        int pos = Integer.parseInt(painPos);
        int code = Integer.parseInt(userCode);

        painService.registPainCodeAndPos(code, pos);

        PainDTO pain = painService.selectPain(code);

        model.addAttribute("pain", pain);

        return "user/pain/regist";
    }

    @GetMapping("/registPain")
    public void regitPain() {
    }

    @PostMapping("/registPain")
    public String registPain(HttpSession session,
                             @RequestParam("pos") String painPos, @RequestParam("code") String userCode,
                             Model model, PainDTO painDTO) {

        int pos = Integer.parseInt(painPos);

        int code = Integer.parseInt(userCode);

        painDTO.setPos(pos);
        painDTO.setUserCode(code);

        painService.registPain(pos, code, painDTO);

        PainDTO pain = painService.selectPain(code);

        model.addAttribute("pain", pain);

        return "user/pain/detail";
    }

    @PostMapping("/delete")
    public String deletePain(@RequestParam("deleteCode") int code, @RequestParam("deletePos") int pos,
                             PainDTO painDTO) {

        painDTO.setUserCode(code);

        painService.deletePain(code, pos);

        return "user/pain/detail";
    }

    @GetMapping("/update")
    public void update() {}

    @PostMapping("/update")
    public String update(HttpSession session,
                         @RequestParam("updateCode") String userCode,
                         Model model) {

        int code = Integer.parseInt(userCode);

        PainDTO pain = painService.selectPain(code);

        model.addAttribute("pain", pain);

        return "user/pain/update";
    }

    @PostMapping("/updatePain")
    public String updatePain(HttpSession session,
                             @RequestParam("pos") String painPos, @RequestParam("updateCode") String userCode,
                             Model model) {

        int pos = Integer.parseInt(painPos);
        int code = Integer.parseInt(userCode);

        painService.update(code, pos);

        PainDTO pain = painService.selectPain(code);

        model.addAttribute("pain", pain);

        return "redirect:user/pain/detail";
    }
}
