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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.willingtogohome.gymga.pass.model.dto.PassAndPassQualDTO;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sale")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }

//    @GetMapping(value = "passdata",produces = "application/json; charset=UTF-8")
//    @ResponseBody
//    public List<PassData> passData(){
//        return saleService.sumPassData();
//    }

    @GetMapping("/selectall")
    public String UserAllList(Model model) {

        List<PassAndPassQualDTO> userList = saleService.findAllList();

        for (PassAndPassQualDTO passAndPassQualDTO : userList){
//            System.out.println("passAndPassQualDTO = " + passAndPassQualDTO);
        }
        model.addAttribute("userList", userList);

        return "sale/selectall";
    }

    @GetMapping("/main")
    public String saleMain(Model model){
        List<PassAndPassQualDTO> PAPQList = saleService.findPassAndPassQualList();

        for (PassAndPassQualDTO papq : PAPQList){
//            System.out.println("papq = " + papq);
        }
        model.addAttribute("PAPQList",PAPQList);

//        List<PassData> passData = saleService.sumPassData();
////        System.out.println("passData = " + passData);
//
//        model.addAttribute("passData", passData);

        List<EmployeeAndUserDTO> employeeAndUserDTO = saleService.empAndUser();
        model.addAttribute("employeeAndUserDTO",employeeAndUserDTO);
//        System.out.println("employeeAndUserDTO = " + employeeAndUserDTO);
//
//        List<EmployeeAndUserDTO> employeeAndUserDTOs = saleService.sumPassPrice();
//        model.addAttribute("employeeAndUserDTOs", employeeAndUserDTOs);

        List<Map<String, Object>> pieChartData = saleService.getDataForPieChart();

        model.addAttribute("pieChartData", pieChartData);
        return "sale/main";
    }

    @PostMapping("/main")
    public String saleMainP(){
        return "redirect:/sale/main";
        }

    @GetMapping("/passDataPie")
    public ResponseEntity<Map<String, Integer>> getPassData() {
        Map<String, Integer> passData = saleService.getPassDataFromDatabase();
        return new ResponseEntity<>(passData, HttpStatus.OK);
    }
    @GetMapping("/passDataBar")
    public ResponseEntity<List<PassMonthDTO>> getPassDataBar() {
        List<PassMonthDTO> passDataForPieChart = saleService.getPassDataForPieChart();
        return ResponseEntity.ok(passDataForPieChart);
    }
//    @GetMapping("/main")
//    public ResponseEntity<List<Map<String, Object>>> getPieChartData() {
//        try {
//            List<Map<String, Object>> pieChartData = saleService.getDataForPieChart();
//            return new ResponseEntity<>(pieChartData, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
//    }
    @GetMapping("/search")
    public void searchUsers() {
    }

    @PostMapping("/search")
    public String userSearch(Model model, @RequestParam String search, @RequestParam String category, HttpSession session) {

        SearchCriteria criteria = new SearchCriteria();
        criteria.setText(search);
        criteria.setCondition(category);

        List<PassAndPassQualDTO> userList = saleService.searchedUser(criteria);

        session.setAttribute("searchedUser", userList);

        model.addAttribute("userList", userList);

        for (PassAndPassQualDTO user : userList) {
//            System.out.println("user = " + user);
        }


//        List<PassData> passData = saleService.sumPassData();
////        System.out.println("passData = " + passData);
//
//        model.addAttribute("passData", passData);

        List<EmployeeAndUserDTO> employeeAndUserDTO = saleService.empAndUser();
        model.addAttribute("employeeAndUserDTO",employeeAndUserDTO);
//        System.out.println("employeeAndUserDTO = " + employeeAndUserDTO);
//
//        List<EmployeeAndUserDTO> employeeAndUserDTOs = saleService.sumPassPrice();
//        model.addAttribute("employeeAndUserDTOs", employeeAndUserDTOs);

        List<Map<String, Object>> pieChartData = saleService.getDataForPieChart();

        model.addAttribute("pieChartData", pieChartData);

        return "sale/search";
    }

//    @GetMapping("/detail")
//    public String detail(Model model, @RequestParam String userId){
//        // userId를 사용하여 사용자 정보를 조회
////        PassAndPassQualDTO userDetail = saleService.getUserDetail(userId);
////
////        // 조회된 사용자 정보를 모델에 추가
////        model.addAttribute("userDetail", userDetail);
//
//        return "sale/detail"; // 사용자 정보가 담긴 뷰로 이동
//    }
    @GetMapping("/detail")
    public void detail(){}


    @PostMapping("/detail")
    public String detail(Model model, @RequestParam String search, @RequestParam String category, HttpSession session){
        SearchCriteria criteria = new SearchCriteria();
        criteria.setText(search);
        criteria.setCondition(category);

        List<PassAndPassQualDTO> detailList = saleService.searchedUserTest(criteria);
        session.setAttribute("detailList", detailList);
        model.addAttribute("detailList", detailList);

        for (PassAndPassQualDTO detail : detailList) {
//            System.out.println("detail = " + detail);
        }

        return "sale/detail";
    }
    @GetMapping("/detail/{userId}")
    public String findByScheduleCode(@PathVariable("userId") String userId, Model model) {
        PassAndPassQualDTO passAndPassQualDTO = saleService.findByUserId(userId);
        model.addAttribute("selectOneUserId", passAndPassQualDTO);
        System.out.println("selectOneUserId = " + passAndPassQualDTO);

        return "sale/detail";
    }


//    @GetMapping("/detail")
//    public String getUserDetails(Model model, @RequestParam("userId") String userId) {
//        // userId를 사용하여 해당 사용자의 상세 정보를 조회
//        PassAndPassQualDTO userDetails = saleService.getUserDetails(userId);
//
//        // 조회된 사용자 상세 정보를 모델에 추가
//        model.addAttribute("userDetails", userDetails);
//
//        // 사용자 상세 정보를 표시하는 뷰로 이동
//        return "sale/detail";
//    }


}
