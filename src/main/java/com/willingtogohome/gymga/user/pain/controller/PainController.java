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
    public String mainPain(HttpSession session,
                           Model model) {
        int code = 0;

        code = (int) session.getAttribute("userCode");

        PainDTO pain = painService.selectPain(code);

        model.addAttribute("pain", pain);
        model.addAttribute("code", code);

        return "pain/detail";
    }

    @GetMapping("/regist")
    public void regist() {
    }

    @PostMapping("/regist")
    public String regist(HttpSession session,
                         @RequestParam("pos") String painPos,
                         Model model) {

        int pos = Integer.parseInt(painPos);
        int code = (int) session.getAttribute("userCode");

        painService.registPainCodeAndPos(code, pos);

        PainDTO pain = painService.selectPain(code);

        model.addAttribute("pain", pain);

        return "pain/regist";
    }

    @GetMapping("/registPain")
    public void regitPain() {
    }

    @PostMapping("/registPain")
    public String registPain(HttpSession session,
                             @RequestParam("pos") String painPos,
                             @RequestParam("type") String painType,
                             @RequestParam("dur") String painDur,
                             @RequestParam("cause") String painCause,
                             @RequestParam("str") String painStr,
                             @RequestParam("etc") String painEtc,
                             Model model, PainDTO painDTO) {

        int pos = Integer.parseInt(painPos);
        int code = (int) session.getAttribute("userCode");
        int str = Integer.parseInt(painStr);

        painDTO.setType(painType);
        painDTO.setDur(painDur);
        painDTO.setCause(painCause);
        painDTO.setStr(str);
        painDTO.setEtc(painEtc);
        painDTO.setPos(pos);
        painDTO.setUserCode(code);

        painService.registPain(painDTO);

        PainDTO pain = painService.selectPain(code);

        model.addAttribute("pain", pain);

        return "redirect:/pain/detail";
    }

    @PostMapping("/delete")
    public String deletePain(@RequestParam("deleteCode") int code, @RequestParam("deletePos") int pos,
                             PainDTO painDTO) {

        painDTO.setUserCode(code);

        painService.deletePain(code, pos);

        return "pain/detail";
    }

    @GetMapping("/update")
    public String update(HttpSession session,
                         @RequestParam("updateCode") String userCode,
                         Model model) {

        int code = 0;

        if (userCode != null) {
            code = Integer.parseInt(userCode);
        } else {
            code = (int) session.getAttribute("userCode");
        }

        PainDTO pain = painService.selectPain(code);

        model.addAttribute("pain", pain);

        return "pain/update";
    }

    @PostMapping("/updatePain")
    public String updatePain(HttpSession session,
                             @RequestParam("updateCode") String userCode,
                             PainDTO painDTO,
                             Model model) {

        int code = 0;

        if (userCode != null) {
            code = Integer.parseInt(userCode);
        } else {
            code = (int) session.getAttribute("userCode");
        }

        painDTO.setUserCode(code);

        painService.update(painDTO);

        return "redirect:/pain/detail";
    }
}
