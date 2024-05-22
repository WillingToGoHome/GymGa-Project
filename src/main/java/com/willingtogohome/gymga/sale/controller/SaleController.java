package com.willingtogohome.gymga.sale.controller;

import com.willingtogohome.gymga.emp.model.dto.SearchCriteria;
import com.willingtogohome.gymga.pass.model.dto.PassMonthDTO;
import com.willingtogohome.gymga.pass.model.dto.UserDTO;
import com.willingtogohome.gymga.sale.model.dto.EmployeeAndUserDTO;
import com.willingtogohome.gymga.sale.model.dto.SaleDTO;
import com.willingtogohome.gymga.sale.model.service.SaleService;
import com.willingtogohome.gymga.schedule.model.dto.ScheduleAndClassAndUserAndPassDTO;
import com.willingtogohome.gymga.user.model.dto.UserAndEmpDTO;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.willingtogohome.gymga.pass.model.dto.PassAndPassQualDTO;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/sale")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }


    @GetMapping("/sale/main")
    public String saleMain(Model model){

        List<PassAndPassQualDTO> PAPQList = saleService.findPassAndPassQualList();
        model.addAttribute("PAPQList",PAPQList);

        for (PassAndPassQualDTO papq : PAPQList){
//            System.out.println("papq = " + papq);
        }

        List<EmployeeAndUserDTO> employeeAndUserDTO = saleService.empAndUser();
        model.addAttribute("employeeAndUserDTO",employeeAndUserDTO);
        return "sale/main";
    }

    @PostMapping("/sale/main")
    public String saleMainP(){
        return "redirect:/sale/main";
        }



    @GetMapping("/sale/passDataBar")
    public ResponseEntity<List<PassMonthDTO>> getPassDataBar() {
        List<PassMonthDTO> passDataForPieChart = saleService.getPassDataForPieChart();
        return ResponseEntity.ok(passDataForPieChart);
    }

    @GetMapping("/sale/passDataPie")
    public ResponseEntity<Map<String, Integer>> getPassData(HttpSession session) {

        SearchCriteria searchCriteria = (SearchCriteria) session.getAttribute("Text");

        session.removeAttribute("passDataPie");
        Map<String, Integer> passData = saleService.getPassDataFromDatabase(searchCriteria);
        return new ResponseEntity<>(passData, HttpStatus.OK);
    }

    @GetMapping("/sale/selectall")
    public String UserAllList(Model model) {

        List<PassAndPassQualDTO> userList = saleService.findAllList();

        for (PassAndPassQualDTO passAndPassQualDTO : userList){
//            System.out.println("passAndPassQualDTO = " + passAndPassQualDTO);
        }
        model.addAttribute("userList", userList);

        return "sale/selectall";
    }

    @GetMapping("/sale/search")
    public void searchUsers() {
    }

    @PostMapping("/sale/search")
    public String userSearch(Model model, @RequestParam String search, @RequestParam String category, HttpSession session) {

        SearchCriteria criteria = new SearchCriteria();
        criteria.setText(search);
        criteria.setCondition(category);

        List<PassAndPassQualDTO> userList = saleService.searchedUser(criteria);

        session.setAttribute("searchedUser", userList);
        session.setAttribute("Text", criteria);

        model.addAttribute("userList", userList);

        for (PassAndPassQualDTO user : userList) {
//            System.out.println("user = " + user);
        }

        List<EmployeeAndUserDTO> employeeAndUserDTO = saleService.empAndUser();
        model.addAttribute("employeeAndUserDTO",employeeAndUserDTO);


        return "sale/search";
    }
    @GetMapping("/sale/detail")
    public String detail(Model model){
        List<PassAndPassQualDTO> detailList = saleService.findAllList();
        model.addAttribute("detailList", detailList);


        return "sale/detail";
    }


    @PostMapping("/sale/detail")
    public String detail(Model model, @RequestParam String search, @RequestParam String category, HttpSession session){
        SearchCriteria criteria = new SearchCriteria();
        criteria.setText(search);
        criteria.setCondition(category);

        List<PassAndPassQualDTO> detailList = saleService.searchedUserTest(criteria);
        session.setAttribute("detailList2", detailList);
        model.addAttribute("detailList", detailList);

        for (PassAndPassQualDTO detail : detailList) {
//            System.out.println("detail = " + detail);
        }

        return "sale/detail";
    }


    @GetMapping("/sale/detail/{userId}")
    public String findByScheduleCode(@PathVariable("userId") String userId, Model model) {
        System.out.println("userId = " + userId);
//        List<PassAndPassQualDTO> detailList = saleService.findAllList();
//        model.addAttribute("detailList", detailList);
        List<PassAndPassQualDTO> userList = saleService.searchByUserId(userId);
        model.addAttribute("userList", userList);
        System.out.println("userList = " + userList);

        List<PassAndPassQualDTO> passAndPassQualDTO = saleService.findByUserId(userId);
        model.addAttribute("selectOneUser", passAndPassQualDTO);




        return "sale/searchdetail";
    }
}
