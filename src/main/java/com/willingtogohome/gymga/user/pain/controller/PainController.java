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

//    @GetMapping("/detail")
//    public void mainPain() {
//    }

    @GetMapping("/detail")
    public String mainPain(HttpSession session,
                           @RequestParam("name") String userName,
                           @RequestParam("code") String userCode, Model model,
                           PainDTO painDTO) {

        int code = (int) session.getAttribute("userCode");

        painDTO.setUserCode(code);

        PainDTO pain = painService.selectPain(code, userName, painDTO);

        model.addAttribute("pain", pain);
        model.addAttribute("name", userName);
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
                         @RequestParam("name") String name,
                         Model model) {

        int pos = Integer.parseInt(painPos);
        int code = Integer.parseInt(userCode);

        painService.registPainCodeAndPos(code, pos);

        model.addAttribute("pos", pos);
        model.addAttribute("name", name);

        return "/user/pain/regist";
    }

    @GetMapping("/registPain")
    public void regitPain() {
    }

    @PostMapping("/registPain")
    public String registPain(HttpSession session,
                             @RequestParam("pos") String painPos, @RequestParam("name") String name,
                             @RequestParam("str") String painStr,
                             Model model, PainDTO painDTO) {

        int pos = Integer.parseInt(painPos);

        int code = (int) session.getAttribute("userCode");

        int str = Integer.parseInt(painStr);

        painDTO.setStr(str);
        painDTO.setPos(pos);
        painDTO.setUserCode(code);

        painService.registPain(painDTO);

        PainDTO pain = painService.resultPain(code, painDTO);

        model.addAttribute("pain", pain);
        model.addAttribute("name", name);

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
    public String update(HttpSession session,
                         @RequestParam("updatePos") String painPos,
                         @RequestParam("updateCode") String userCode,
                         @RequestParam("updateName") String name,
                         Model model) {

        int pos = Integer.parseInt(painPos);
        int code = Integer.parseInt(userCode);

        session.setAttribute("userCode", code);

        PainDTO pain = painService.updatePain(code);

        pain.setUserName(name);

        model.addAttribute("pos", pos);
        model.addAttribute("pain", pain);
        model.addAttribute("name", name);

        System.out.println(pos);

        return "/user/pain/update";
    }

    @GetMapping("/updatePain")
    public void updatePain() {}

    @PostMapping("/updatePain")
    public String updatePain(HttpSession session,
                             @RequestParam("pos") String painPos, @RequestParam("updateName") String name,
                             Model model, PainDTO painDTO) {

        int pos = Integer.parseInt(painPos);

        int code = (int) session.getAttribute("userCode");

        painDTO.setPos(pos);
        painDTO.setUserCode(code);

        painService.update(painDTO);

        PainUpdateDTO pain = painService.getPainByCode(code, painDTO);

        model.addAttribute("pain", pain);
        model.addAttribute("name", name);

        System.out.println(pos);
        System.out.println(code);

        return "/user/pain/detail";
    }
}
