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

    @GetMapping("/detail")
    public void mainPain() {
    }

    @PostMapping("/detail")
    public String mainPain(HttpSession session,
                           @RequestParam("name") String userName,
                           @RequestParam("code") String userCode, Model model,
                           PainDTO painDTO) {

        int code = (int) session.getAttribute("userCode");

        painDTO.setUserCode(code);

        PainDTO pain = painService.selectPain(code, userName, painDTO);

        model.addAttribute("pain", pain);
        model.addAttribute("userName", userName);
        model.addAttribute("userCode", userCode);

        return "/user/pain/detail";
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

        model.addAttribute("pos", pos);

        return "/user/pain/regist";
    }

    @GetMapping("/registPain")
    public void regitPain() {
    }

    @PostMapping("/registPain")
    public String registPain(HttpSession session,
                             @RequestParam("pos") String painPos,
                             Model model, PainDTO painDTO) {

        int pos = Integer.parseInt(painPos);

        int code = (int) session.getAttribute("userCode");

        painDTO.setPos(pos);
        painDTO.setUserCode(code);

        painService.registPain(painDTO);

        System.out.println(pos);
        System.out.println(code);

        return "/user/pain/detail";
    }

    @PostMapping("/delete")
    public String deletePain(@RequestParam("deleteCode") int code, @RequestParam("deletePos") int pos) {

        painService.deletePain(code, pos);

        return "/user/pain/detail";
    }

    @GetMapping("/update")
    public void update() {}

    @PostMapping("/update")
    public String update(@RequestParam("updatePos") String painPos,
                         @RequestParam("updateCode") String userCode,
                         Model model) {

        int pos = Integer.parseInt(painPos);

        int code = Integer.parseInt(userCode);

        PainDTO pain = painService.updatePain(code);

        model.addAttribute("pos", pos);

        model.addAttribute("pain", pain);

        System.out.println(pos);

        return "/user/pain/update";
    }

    @GetMapping("/updatePain")
    public void updatePain() {}

    @PostMapping("/updatePain")
    public String updatePain(HttpSession session,
                             @RequestParam("pos") String painPos,
                             Model model, PainDTO painDTO) {

        int pos = Integer.parseInt(painPos);

        int code = (int) session.getAttribute("userCode");

        painDTO.setPos(pos);
        painDTO.setUserCode(code);

        painService.update(painDTO);

        System.out.println(pos);
        System.out.println(code);

        return "/user/pain/detail";
    }
}
