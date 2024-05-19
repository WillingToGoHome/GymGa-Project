package com.willingtogohome.gymga.pass.controller;

import com.willingtogohome.gymga.pass.model.dto.*;
import com.willingtogohome.gymga.pass.model.service.PassService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;
import java.util.List;

@Controller
@RequestMapping("/pass")
public class PassController {

    private final PassService passService;

    @Autowired
    public PassController(PassService passService) {

        this.passService = passService;
    }

    @GetMapping(value={"/", "/main"})
    public String passMain() {

        return "/pass/main";
    }

    @GetMapping("/regist1")
    public String passRegist1() {

        return "/pass/regist1";
    }

    @GetMapping(value = "/empList", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<UserDTO> findEmpList() {

        return passService.selectAllEmp();
    }

    @PostMapping("/regist2")
    public String passRegist2(HttpSession session, PassDTO passDTO, SaleDTO saleDTO) {

//        System.out.println("passDTO = " + passDTO);
//        System.out.println("saleDTO = " + saleDTO);

        session.setAttribute("passDTO", passDTO);
        session.setAttribute("saleDTO", saleDTO);

        return "/pass/regist2";
    }

    @GetMapping(value = "/searchMember")
    public String findMemberList(Model model, @RequestParam String name) {

        List<UserDTO> memberList =  passService.selectAllMember(new SearchCriteria("name", name));

        model.addAttribute("memberList", memberList);

        return "/pass/regist2";
    }

    @PostMapping("/regist")
    public String passRegist(HttpSession session,
                             @RequestParam String memberCode) {

        PassDTO passDTO = (PassDTO) session.getAttribute("passDTO");
        SaleDTO saleDTO = (SaleDTO) session.getAttribute("saleDTO");

        int code = passService.findMaxCode();

        passDTO.setPassCode(code + 1);
        passDTO.setPassStatus("유효");
        saleDTO.setMemberCode(Integer.parseInt(memberCode));
        ValidateDTO validateDTO = new ValidateDTO("유효", code + 1, Integer.parseInt(memberCode));

//        System.out.println("memberCode = " + memberCode);
//        System.out.println("passDTO = " + passDTO);
//        System.out.println("saleDTO = " + saleDTO);
//        System.out.println("validateDTO = " + validateDTO);

        passService.registNewPass(passDTO, saleDTO, validateDTO);

        return "redirect:/pass/main";
    }

    @GetMapping("/search")
    public String passSearch() {

        return "/pass/search";
    }

    @GetMapping("/update")
    public String passUpdate(Model model){

        List<PassAndPassQualDTO> passList = passService.selectAllPassAndUser();

        for (PassAndPassQualDTO pass : passList) {
            System.out.println("pass = " + pass);
        }

        model.addAttribute("passList", passList);

        return "/pass/update";
    }


}
