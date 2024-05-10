//package com.willingtogohome.gymga.login.auth.controller;
//
////import com.willingtogohome.gymga.login.auth.model.service.AuthService;
//import com.willingtogohome.gymga.login.common.UserRole;
//import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//
//import static com.willingtogohome.gymga.login.common.UserRole.ADMIN;
//
//@Controller
//public class MainController {
//
//    private final AuthService authService;
//
//    @Autowired
//    public MainController(AuthService authService) { this.authService = authService ;}
//
//    @GetMapping(value = "/login")
//    public void login(){}
//
//    @PostMapping(value = "/login")
//    public String loginPost(Model model, @ModelAttribute LoginDTO loginDTO, @RequestParam("userId") String userId, @RequestParam("userPwd") String userPwd){
//
//        System.out.println(userId);
//        // 사용자의 역할 확인
//        List<String> role = (List<String>) authService.loadUserByUsername(userId); // 사용자의 역할 정보가 LoginDTO에 role 필드로 저장.
//        System.out.println(role);
//        // 사용자의 역할에 따라 리다이렉트할 페이지 결정
//        if (ADMIN.equals(role)) {
//            return "redirect:/login/admin/admin"; // 관리자 페이지로 리다이렉트
//        } else {
//            return "redirect:/login/user/user"; // 사용자 페이지로 리다이렉트
//        }
//    }
//
//    @GetMapping("/login/auth/fail")
//    public ModelAndView loginFail(ModelAndView mv, @RequestParam String message) {
//
//        mv.addObject("message", message);
//        mv.setViewName("/login/auth/fail");
//        return mv;
//    }
//
//    /*PostMapping후 권한 구분 없이 순서대로 페이지가 뜸..*/
//
//    @GetMapping("/user/user")
//    public String userPage(){
//        return "login/user/user";
//    }
//
//    @GetMapping("/admin/admin")
//    public String adminPage(){
//        return "login/admin/admin";
//    }
//
//    @GetMapping("/login/admin/essential1")
//    public String essential1(Model model) throws IOException {
//        String filePath = "/templates/login/admin/essential1";
//
//        try {
//            Path path = Paths.get(new ClassPathResource(filePath).getURI());
//            String fileContent = new String(Files.readAllBytes(path));
//            model.addAttribute("fileContent", fileContent);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "/login/admin/essential1";
//    }
//
//
//}
