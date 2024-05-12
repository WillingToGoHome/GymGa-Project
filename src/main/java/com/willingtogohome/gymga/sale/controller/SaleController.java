package com.willingtogohome.gymga.sale.controller;

import com.willingtogohome.gymga.pass.model.dto.PassMonthDTO;
import com.willingtogohome.gymga.sale.model.dto.EmployeeAndUserDTO;
import com.willingtogohome.gymga.sale.model.dto.SaleDTO;
import com.willingtogohome.gymga.sale.model.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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


    @GetMapping("/main")
    public String saleMain(Model model){
        List<PassAndPassQualDTO> PAPQList = saleService.findPassAndPassQualList();

        for (PassAndPassQualDTO papq : PAPQList){
//            System.out.println("papq = " + papq);
        }
        model.addAttribute("PAPQList",PAPQList);


        List<SaleDTO> saleList = saleService.findAllList();

        for (SaleDTO sales : saleList){
//            System.out.println("sales = " + sales);
        }
        model.addAttribute("saleList", saleList);


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
    public String saleMainP(Model model){
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
}
