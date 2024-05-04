package com.willingtogohome.gymga.pass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pass")
public class PassController {

    @GetMapping(value={"/", "/main"})
    public String passMain() {

        return "/pass/main";
    }
}
