package com.willingtogohome.gymga.fac.controller;

import com.willingtogohome.gymga.fac.model.dto.FacAndUserDTO;
import com.willingtogohome.gymga.fac.model.dto.FacDTO;
import com.willingtogohome.gymga.fac.model.dto.UserDTO;
import com.willingtogohome.gymga.fac.model.service.FacService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/fac")
public class FacController {

    private final FacService facService;

    public FacController(FacService facService) {
        this.facService=facService;
    }

    @GetMapping("/select")
    public String findFacList(Model model) {
        List<FacDTO> facList=facService.findAllFac();

        for(FacDTO facs:facList) {
            System.out.println("facs = " + facs);
        }
        model.addAttribute("facList",facList);

        return "fac/select";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @GetMapping(value = "user", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<UserDTO> findUserList() {
        return facService.findAllUser();
    }

    @GetMapping(value = "fac", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<FacDTO> findFacList() {
        return facService.findAllFac();
    }

    @PostMapping("/regist")
    public String registFac(FacDTO newFac, RedirectAttributes rttr) {
        facService.registNewFac(newFac);

        rttr.addFlashAttribute("successMessage","사물함 등록 성공");

        return "redirect:/fac/select";
    }


}
