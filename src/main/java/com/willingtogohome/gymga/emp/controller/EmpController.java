package com.willingtogohome.gymga.emp.controller;

import com.willingtogohome.gymga.emp.model.dto.*;
import com.willingtogohome.gymga.emp.model.service.EmpService;
import jakarta.servlet.http.HttpSession;
import lombok.ToString;
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
    public String empRegist(EmpDTO empDTO, PhysicalDTO physicalDTO, EmployeeDTO employeeDTO, RedirectAttributes rttr,
                            @RequestParam String qualWrite, @RequestParam String address1, @RequestParam String address2) {

        int code = empService.findLastCode();

        System.out.println("empDTO = " + empDTO);
        System.out.println("physicalDTO = " + physicalDTO);
        System.out.println("employeeDTO = " + employeeDTO);
        System.out.println("qualWrite = " + qualWrite);

        if (qualWrite != "") {
            String qual = employeeDTO.getQual() + "," + qualWrite;
            System.out.println(employeeDTO.getQual() + "," + qualWrite);
            employeeDTO.setQual(qual);
        }

        empDTO.setRole("직원");
        empDTO.setAddress(address1 + " " + address2);
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

        System.out.println("search = " + search);
        System.out.println("category = " + category);
        System.out.println("model = " + model);

        EmpTotDTO emp = empService.searchBy(new SearchCriteria(category, search));
        List<EmpDTO> empList = empService.selectAllEmp();

        session.setAttribute("searched", emp.getCode());

        model.addAttribute("emp", emp);
        model.addAttribute("empList", empList);

        return "/emp/result";
    }

    @GetMapping("/update")
    public String empUpdate(HttpSession session, Model model) {

        int code = (int) session.getAttribute("searched");
        System.out.println("code = " + code);
        String text = Integer.toString(code);
        System.out.println("text = " + text);

        EmpTotDTO emp = empService.searchBy(new SearchCriteria("code", text));
        System.out.println("emp = " + emp);

        model.addAttribute("emp", emp);

        return "/emp/update";
    }

//    @PostMapping("/update")
//    public String empUpdate(EmpDTO empDTO, PhysicalDTO physicalDTO, EmployeeDTO employeeDTO,
//                            HttpSession session) {
//
//        int code = (int) session.getAttribute("searched");
//        System.out.println("updatecode = " + code);
//
//        empDTO.setCode(code);
//        physicalDTO.setCode(code);
//        employeeDTO.setCode(code);
//
//        System.out.println("empDTO = " + empDTO);
//        System.out.println("physicalDTO = " + physicalDTO);
//        System.out.println("employeeDTO = " + employeeDTO);
//
//        empService.updateEmp(empDTO, physicalDTO, employeeDTO);
//
//        return "redirect:/emp/detail";
//    }

    @PostMapping("detail")
    public String empDetail(EmpDTO empDTO, PhysicalDTO physicalDTO, EmployeeDTO employeeDTO,
                            HttpSession session, Model model,
                            @RequestParam String address1, @RequestParam String address2) {

        int code = (int) session.getAttribute("searched");
        String text = Integer.toString(code);

        System.out.println("address1 = " + address1);
        System.out.println("address2 = " + address2);

        if (address1 != "") {
            String address = address1 + " " + address2;
            System.out.println(address);
            empDTO.setAddress(address);
        }

        empDTO.setCode(code);
        physicalDTO.setCode(code);
        employeeDTO.setCode(code);

        System.out.println("empDTO = " + empDTO);
        System.out.println("physicalDTO = " + physicalDTO);
        System.out.println("employeeDTO = " + employeeDTO);

        empService.updateEmp(empDTO, physicalDTO, employeeDTO);

        EmpTotDTO emp = empService.searchBy(new SearchCriteria("code", text));
        List<EmpDTO> empList = empService.selectAllEmp();

        System.out.println("emp = " + emp);

        model.addAttribute("emp", emp);
        model.addAttribute("empList", empList);

        return "/emp/detail";
    }

//    @GetMapping("/detail")
//    public String empDetail(HttpSession session, Model model) {
//
//        System.out.println("getDetail");
//
//        int code = (int) session.getAttribute("searched");
//        String text = Integer.toString(code);
//
//        EmpTotDTO emp = empService.searchBy(new SearchCriteria("code", text));
//        List<EmpDTO> empList = empService.selectAllEmp();
//
//        System.out.println("emp = " + emp);
//
//        model.addAttribute("emp", emp);
//        model.addAttribute("empList", empList);
//
//        return "/emp/detail";
//    }

    @PostMapping("/remove")
    public String empRemove(HttpSession session) {

        int code = (int) session.getAttribute("searched");
        empService.removeEmp(code);

        return "redirect:/emp/main";
    }

    @GetMapping("/test")
    public String empTest() {

        return "/emp/test";
    }
}
