package com.willingtogohome.gymga.sale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SaleController {

    @GetMapping("/sale/main")
    public String saleMain(){

        return "sale/main";
    }






}
