package com.willingtogohome.gymga.fac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/facility")
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

        return "facility/select";
    }
}
