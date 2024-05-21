package com.willingtogohome.gymga.login.user.controller;

import com.willingtogohome.gymga.emp.model.dto.EmployeeDTO;
import com.willingtogohome.gymga.emp.model.dto.PhysicalDTO;
import com.willingtogohome.gymga.emp.model.service.EmpService;
import com.willingtogohome.gymga.login.user.model.dto.RegistDTO;
import com.willingtogohome.gymga.login.user.model.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {

    private final LoginService loginService;
    private final EmpService empService;

    @Autowired
    public LoginController(LoginService loginService, EmpService empService) {
        this.loginService = loginService;
        this.empService = empService;
    }

    @GetMapping("/login/admin/regist")
    public String regist(){
        return "/login/admin/regist";
    }

    @PostMapping("/login/admin/regist")
    public ModelAndView regist(@ModelAttribute RegistDTO registDTO) {
        ModelAndView mv = new ModelAndView();

        int code = empService.findLastCode() + 1;

        registDTO.setUserCode(code);
        registDTO.setUserPic("default-user.png");

        PhysicalDTO physicalDTO = new PhysicalDTO(code, "", "", "");
        EmployeeDTO employeeDTO = new EmployeeDTO(code, "", "0", "0", "0", "0", "", "2000000");

        System.out.println("registDTO = " + registDTO);
        System.out.println("physicalDTO = " + physicalDTO);
        System.out.println("employeeDTO = " + employeeDTO);

        int result = loginService.regist(registDTO, physicalDTO, employeeDTO);

        String message = "";

        if (result > 0) {
            message = "회원가입에 성공하였습니다.";
        } else {
            message = "회원가입에 실패하였습니다.";
        }
        mv.addObject("message", message);
        mv.setViewName("/login");
        return mv;
    }

    @GetMapping(value = "/login/auth/find")
    public String find(){
        return "/login/auth/find";
    }

    @RequestMapping(value = "/login/auth/find_id", method = RequestMethod.POST)
    @ResponseBody
    public String find_id(@Param("userName") String userName, @Param("userPhone") String userPhone) {
        String result = loginService.find_id(userName,userPhone);
        System.out.println(userName);
        System.out.println(userPhone);
        return result;
    }

    @RequestMapping(value = "/login/auth/find_pwd", method = RequestMethod.POST)
    @ResponseBody
    public String find_pwd(@RequestParam("userId") String userId, @RequestParam("userPhone") String userPhone) {

        String result = loginService.find_pwd(userId, userPhone);
        System.out.println(userId);
        System.out.println(userPhone);
        return  result;
    }
// 수빈님꺼 주석
//    @GetMapping(value = "/login/idCheck", produces = "application/json; charset=UTF-8")
//    @ResponseBody
//    public List<RegistDTO> idCheck(){
//
//        loginService.idCheck().forEach(System.out::println);
//
//        return loginService.idCheck();
//    }

    /* 아이디 중복 체크 */
    @RequestMapping(value = "/login/auth/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("id") String userId) {
        int cnt = loginService.idCheck(userId);

        return cnt;
    }




}
