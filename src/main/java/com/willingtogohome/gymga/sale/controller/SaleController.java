package com.willingtogohome.gymga.sale.controller;

import com.willingtogohome.gymga.pass.model.dto.PassData;
import com.willingtogohome.gymga.sale.model.dto.SaleDTO;
import com.willingtogohome.gymga.sale.model.service.SaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.willingtogohome.gymga.pass.model.dto.PassAndPassQualDTO;

import java.util.List;

@Controller
@RequestMapping("/")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }

    @GetMapping("/sale/main")
    public String saleMain(Model model){

        List<PassAndPassQualDTO> PAPQList = saleService.findPassAndPassQualList();

        for (PassAndPassQualDTO papq : PAPQList){
            System.out.println("papq = " + papq);
        }
        model.addAttribute("PAPQList",PAPQList);

        List<SaleDTO> saleList = saleService.findAllList();

//        for (SaleDTO sales : saleList){
//            System.out.println("sales = " + sales);
//        }
        model.addAttribute("saleList", saleList);

        List<PassData> passData = saleService.sumPassData();
        model.addAttribute("passData", passData);



        return "sale/main";
    }
}
