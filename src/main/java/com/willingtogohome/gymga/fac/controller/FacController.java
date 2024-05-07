package com.willingtogohome.gymga.fac.controller;

import com.willingtogohome.gymga.fac.model.dto.FacDTO;
import com.willingtogohome.gymga.fac.model.dto.UserDTO;
import com.willingtogohome.gymga.fac.model.service.FacService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/select/expired")
    public String findExpList(Model model) {
        List<FacDTO> facList=facService.findAllExp();

        for(FacDTO facs:facList) {
            System.out.println("facs = " + facs);
        }
        model.addAttribute("facList",facList);

        return "fac/select";
    }

    @GetMapping("/select/personal")
    public String findPerList(@RequestParam int facCode, Model model) {
        FacDTO facList=facService.findAllPer(facCode);


        model.addAttribute("facList", facList);
        System.out.println("facList = " + facList);


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

    @GetMapping("/update")
    public void updatePage() {}

    @PostMapping("/update")
    public String updateFac(FacDTO renewFac, RedirectAttributes rttr) {
        facService.updateRenewFac(renewFac);

        rttr.addFlashAttribute("successMessage", "메뉴 수정에 성공!");

        return "redirect:/fac/select";
    }

    @GetMapping("/delete")
    public void deletePage() {}

    @PostMapping("/delete")
    public String deleteFac(FacDTO deleteFac, RedirectAttributes rttr) {
        facService.deleteFac(deleteFac);

        rttr.addFlashAttribute("successMessage", "메뉴 삭제 성공");

        return "redirect:/fac/select";
    }




}
