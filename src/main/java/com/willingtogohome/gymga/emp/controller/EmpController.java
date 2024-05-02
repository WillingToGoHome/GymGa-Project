package com.willingtogohome.gymga.emp.controller;

import com.willingtogohome.gymga.emp.model.dto.*;
import com.willingtogohome.gymga.emp.model.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {

        this.empService = empService;
    }

    @GetMapping(value={"/", "/main"})
    public String empMain(Model model) {

        List<EmpDTO> empList = empService.selectAllEmp();
        List<ScheDTO> scheList = empService.selectAllSche();

        model.addAttribute("empList", empList);
        model.addAttribute("scheList", scheList);

        return "/emp/main";
    }

    @GetMapping("/regist")
    public String registPage() {

        return "/emp/regist";
    }

    @PostMapping("/regist")
    public String empRegist(EmpDTO empDTO, PhysicalDTO physicalDTO, EmployeeDTO employeeDTO, RedirectAttributes rttr) {

        int code = empService.findLastCode();

        empDTO.setRole("직원");
        empDTO.setCode(code + 1);
        physicalDTO.setCode(code + 1);
        employeeDTO.setCode(code + 1);

        empService.registNewEmp(empDTO, physicalDTO, employeeDTO);

        return "redirect:/emp/main";
    }

    @GetMapping("/search")
    public String empSearch(Model model) {

        List<EmpDTO> empList = empService.selectAllEmp();

        model.addAttribute("empList", empList);

        return "/emp/search";
    }

    @GetMapping("/result")
    public String empResult(Model model, @RequestParam String search, @RequestParam String category, HttpSession session) {

        EmpTotDTO emp = empService.searchBy(new SearchCriteria(category, search));
        List<EmpDTO> empList = empService.selectAllEmp();

        session.setAttribute("searched", emp.getCode());

        model.addAttribute("emp", emp);
        model.addAttribute("empList", empList);

        return "/emp/result";
    }

    @PostMapping("/remove")
    public String empRemove(HttpSession session) {

        int code = (int) session.getAttribute("searched");
        empService.removeEmp(code);

        return "redirect:/emp/main";
    }
}
