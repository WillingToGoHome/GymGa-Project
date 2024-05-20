package com.willingtogohome.gymga.pass.controller;

import com.willingtogohome.gymga.pass.model.dto.*;
import com.willingtogohome.gymga.pass.model.service.PassService;
import com.willingtogohome.gymga.user.model.dto.PhysicalDTO;
import com.willingtogohome.gymga.user.model.dto.UserAndEmpDTO;
import com.willingtogohome.gymga.user.model.dto.UserTotDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Parameter;
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
    public String passRegist1() {

        return "/pass/regist1";
    }

    @GetMapping(value = "/empList", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<UserDTO> findEmpList() {

        return passService.selectAllEmp();
    }

    @PostMapping("/regist2")
    public String passRegist2(HttpSession session, PassDTO passDTO, SaleDTO saleDTO) {

//        System.out.println("passDTO = " + passDTO);
//        System.out.println("saleDTO = " + saleDTO);

        session.setAttribute("passDTO", passDTO);
        session.setAttribute("saleDTO", saleDTO);

        return "/pass/regist2";
    }

    @GetMapping(value = "/searchMember")
    public String findMemberList(Model model, @RequestParam String name) {

        List<UserDTO> memberList =  passService.selectAllMember(new SearchCriteria("name", name));

        model.addAttribute("memberList", memberList);

        return "/pass/regist2";
    }

    @PostMapping("/regist")
    public String passRegist(HttpSession session,
                             @RequestParam String memberCode) {

        PassDTO passDTO = (PassDTO) session.getAttribute("passDTO");
        SaleDTO saleDTO = (SaleDTO) session.getAttribute("saleDTO");

        int code = passService.findMaxCode();

        passDTO.setPassCode(code + 1);
        passDTO.setPassStatus("유효");
        saleDTO.setMemberCode(Integer.parseInt(memberCode));
        ValidateDTO validateDTO = new ValidateDTO("유효", code + 1, Integer.parseInt(memberCode));

//        System.out.println("memberCode = " + memberCode);
//        System.out.println("passDTO = " + passDTO);
//        System.out.println("saleDTO = " + saleDTO);
//        System.out.println("validateDTO = " + validateDTO);

        passService.registNewPass(passDTO, saleDTO, validateDTO);

        return "redirect:/pass/main";
    }

    @GetMapping("/updatesearch")
    public void searchPage(){}

    @PostMapping("/updatesearch")
    public String userSearch(Model model, @RequestParam String search, @RequestParam String category, HttpSession session) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setText(search);
        criteria.setCondition(category);

        List<PassAndPassQualDTO> passList = passService.searchUser(criteria);

        session.setAttribute("passList", passList);

        model.addAttribute("passList", passList);

        for (PassAndPassQualDTO pass : passList) {
            System.out.println("pass = " + pass);
        }

        return "/pass/updatesearch";
    }


    @GetMapping("/update")
    public String passUpdate(Model model){

        List<PassAndPassQualDTO> passList = passService.selectAllPassAndUser();

        for (PassAndPassQualDTO pass : passList) {
            System.out.println("pass = " + pass);
        }

        model.addAttribute("passList", passList);

        return "/pass/update";
    }

    @GetMapping(value = "/class", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<PassQualDTO> findPqNameList() {
        passService.findPqNameList().forEach(System.out::println);
        return passService.findPqNameList();
    }



    /* 이용권 조회 - 김만호 */
    /* 등록 이용권 조회 메인페이지 생성*/
    @GetMapping("/passlist")
    public void allPassListPage(){}
    /* 등록 이용권 조회 모델에 담기*/
    @GetMapping("/selectAllPass")
    public String allPassList(Model model){

        List<PassAndPassQualDTO> passAllList = passService.searchPassList();

        for (PassAndPassQualDTO pass : passAllList) {
            System.out.println("passAllList = " + pass);
        }

        model.addAttribute("passAllList", passAllList);

        return "/pass/passlist";
    }
    /* 검색 결과 페이지 */
    @GetMapping("/listsearch")
    public void searchListPage(){}

    /* 검색 결과 페이지 검색 조건*/
    @PostMapping("/listsearch")
    public String allPassList(Model model, @RequestParam String search, @RequestParam String category, HttpSession session) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setText(search);
        criteria.setCondition(category);

        List<PassAndPassQualDTO> passSearchList = passService.searchPass(criteria);

        for (PassAndPassQualDTO passSearch : passSearchList) {
            System.out.println("pass = " + passSearch);
        }

        session.setAttribute("passSearchList", passSearchList);
        model.addAttribute("passSearchList", passSearchList);

        return "/pass/listsearch";

    }

    /* 이용권 상세 페이지 */

    @GetMapping("/selectDetail")
    public void passDetailPage(){
    }

    @PostMapping("/selectDetail")
    public String selectDetail(@RequestParam("code") Integer userCode,
                               @RequestParam("passCode")Integer passCode, Model model) {

        PassAndPassQualDTO user = passService.getInfoDetailByCode(userCode, passCode);
        model.addAttribute("user", user);
        System.out.println("user = " + user);

        /* 이용권 목록 */

        List<PassAndPassQualDTO> oneMemberAllPassList = passService.oneMemberAllPassListByCode(userCode);
        model.addAttribute("oneMemberAllPassList", oneMemberAllPassList);

        /* PT, GX 카운터 */
        List<PassCountDTO> userPassCount = passService.getCountByCode(userCode);
        model.addAttribute("userPassCount", userPassCount);
        System.out.println("userPassCount = " + userPassCount);

        return "/pass/selectDetail";
    }




}
