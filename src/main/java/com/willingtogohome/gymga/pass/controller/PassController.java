package com.willingtogohome.gymga.pass.controller;

import com.willingtogohome.gymga.pass.model.dto.UserDTO;
import com.willingtogohome.gymga.pass.model.service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String passGetRegist() {

        return "/pass/regist1";
    }

    @GetMapping(value = "/empList", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<UserDTO> findEmpList() {

        return passService.selectAllEmp();
    }
}
