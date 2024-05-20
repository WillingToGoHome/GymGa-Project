package com.willingtogohome.gymga.login.auth.controller;

import com.willingtogohome.gymga.emp.model.dao.EmpMapper;
import com.willingtogohome.gymga.emp.model.dto.ScheDTO;
import com.willingtogohome.gymga.emp.model.dto.SearchCriteria;
import com.willingtogohome.gymga.emp.model.service.EmpService;
import com.willingtogohome.gymga.login.auth.model.dto.MemberAndPassDTO;
import com.willingtogohome.gymga.login.auth.model.service.MainService;
import com.willingtogohome.gymga.pass.model.dto.PassMonthDTO;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final MainService mainService;
    private final EmpService empService;

    @Autowired
    public MainController(MainService mainService, EmpService empService) {
        this.mainService = mainService;
        this.empService = empService;
    }

    @GetMapping(value = "/login")
    public void login(){}

    @GetMapping(value = "/login/auth/fail")
    public ModelAndView loginFail(ModelAndView mv, @RequestParam String message) {

        mv.addObject("message", message);
        mv.setViewName("/login/auth/fail");

        return mv;
    }

    @GetMapping(value = "/main")
    public String main(SecurityContextHolder securityContextHolder, HttpSession session, Model model) {

        int userCode = Integer.parseInt(securityContextHolder.getContext().getAuthentication().getName());
        UserDTO emp = mainService.selectEmpBy(userCode);

        String role = emp.getUserRole();

        List<MemberAndPassDTO> memberList = mainService.selectMemberList();

        model.addAttribute("memberList", memberList);

        if (role.equals("ADMIN")) {
            List<ScheDTO> scheList1 = empService.selectAllSche(new SearchCriteria("0", "8:00am"));
            List<ScheDTO> scheList2 = empService.selectAllSche(new SearchCriteria("0", "10:00am"));
            List<ScheDTO> scheList3 = empService.selectAllSche(new SearchCriteria("0", "12:00pm"));
            List<ScheDTO> scheList4 = empService.selectAllSche(new SearchCriteria("0", "14:00pm"));
            List<ScheDTO> scheList5 = empService.selectAllSche(new SearchCriteria("0", "16:00pm"));
            List<ScheDTO> scheList6 = empService.selectAllSche(new SearchCriteria("0", "18:00pm"));
            model.addAttribute("scheList1", scheList1);
            model.addAttribute("scheList2", scheList2);
            model.addAttribute("scheList3", scheList3);
            model.addAttribute("scheList4", scheList4);
            model.addAttribute("scheList5", scheList5);
            model.addAttribute("scheList6", scheList6);
        } else {
            session.setAttribute("searched", userCode);
            List<ScheDTO> scheList1 = empService.selectAllSche(new SearchCriteria(Integer.toString(userCode), "8:00am"));
            List<ScheDTO> scheList2 = empService.selectAllSche(new SearchCriteria(Integer.toString(userCode), "10:00am"));
            List<ScheDTO> scheList3 = empService.selectAllSche(new SearchCriteria(Integer.toString(userCode), "12:00pm"));
            List<ScheDTO> scheList4 = empService.selectAllSche(new SearchCriteria(Integer.toString(userCode), "14:00pm"));
            List<ScheDTO> scheList5 = empService.selectAllSche(new SearchCriteria(Integer.toString(userCode), "16:00pm"));
            List<ScheDTO> scheList6 = empService.selectAllSche(new SearchCriteria(Integer.toString(userCode), "18:00pm"));
            model.addAttribute("scheList1", scheList1);
            model.addAttribute("scheList2", scheList2);
            model.addAttribute("scheList3", scheList3);
            model.addAttribute("scheList4", scheList4);
            model.addAttribute("scheList5", scheList5);
            model.addAttribute("scheList6", scheList6);
        }

        return "main";
    }

    @GetMapping("/main/piedata")
    public ResponseEntity<Map<String, Integer>> getPieData(SecurityContextHolder securityContextHolder) {

        int userCode = Integer.parseInt(securityContextHolder.getContext().getAuthentication().getName());
        UserDTO emp = mainService.selectEmpBy(userCode);

        Map<String, Integer> graphData = new HashMap<>();

        if (emp.getUserRole().equals("ADMIN")) {
            graphData = mainService.getPieData(0);
        } else {
            graphData = mainService.getPieData(emp.getUserCode());
        }

        return new ResponseEntity<>(graphData, HttpStatus.OK);
    }

    @GetMapping("/main/bardata")
    public ResponseEntity<List<PassMonthDTO>> getBarData(SecurityContextHolder securityContextHolder) {

        int userCode = Integer.parseInt(securityContextHolder.getContext().getAuthentication().getName());
        UserDTO emp = mainService.selectEmpBy(userCode);

        List<PassMonthDTO> graphData = new ArrayList<>();

        if (emp.getUserRole().equals("ADMIN")) {
            graphData = mainService.getBarData(0);
        } else {
            graphData = mainService.getBarData(emp.getUserCode());
        }

        return new ResponseEntity<>(graphData, HttpStatus.OK);
    }

    @GetMapping(value = "/main/info", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public UserDTO findLoginInfo(SecurityContextHolder securityContextHolder) {

        int userCode = Integer.parseInt(securityContextHolder.getContext().getAuthentication().getName());

        return mainService.selectEmpBy(userCode);
    }
}