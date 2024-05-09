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


//    @GetMapping("/regist")
//    public String registFac(@RequestParam("facCode") int facCode, Model model) {
//        model.addAttribute("facCode", facCode);
//        return "fac/select";
//    }

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



    @PostMapping("/update")
    public String updateFac(FacDTO renewFac, RedirectAttributes rttr) {
        facService.updateRenewFac(renewFac);

        rttr.addFlashAttribute("successMessage", "메뉴 수정에 성공!");

        return "redirect:/fac/select";
    }

//    @GetMapping("/delete")
//    public String deletePage(Model model) {
//        // 모달창 스크립트에 전달할 값을 모델에 추가
//        model.addAttribute("delResult", "someValue"); // 삭제 결과에 따른 값을 여기에 설정해야 합니다.
//        model.addAttribute("bno", "someValue"); // 삭제된 게시물 번호에 해당하는 값을 여기에 설정해야 합니다.
//        return "yourViewName"; // 해당하는 뷰의 이름으로 변경해야 합니다.
//    }

    @PostMapping("/delete")
    public String deleteFac(FacDTO deleteFac, RedirectAttributes rttr) {
        facService.deleteFac(deleteFac);

        rttr.addFlashAttribute("successMessage", "메뉴 삭제 성공");

        return "redirect:/fac/select";
    }




}
