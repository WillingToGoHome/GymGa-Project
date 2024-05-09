package com.willingtogohome.gymga.emp.controller;

import com.willingtogohome.gymga.emp.model.dto.*;
import com.willingtogohome.gymga.emp.model.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/emp")
public class EmpController {

    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {

        this.empService = empService;
    }

    @GetMapping(value={"/", "/main"})
    public String empMain(Model model) {

        List<EmpDTO> empList = empService.selectAllEmp();
        List<ScheDTO> scheList1 = empService.selectAllSche(new SearchCriteria("time", "8:00am"));
        List<ScheDTO> scheList2 = empService.selectAllSche(new SearchCriteria("time", "10:00am"));
        List<ScheDTO> scheList3 = empService.selectAllSche(new SearchCriteria("time", "12:00pm"));
        List<ScheDTO> scheList4 = empService.selectAllSche(new SearchCriteria("time", "14:00pm"));
        List<ScheDTO> scheList5 = empService.selectAllSche(new SearchCriteria("time", "16:00pm"));
        List<ScheDTO> scheList6 = empService.selectAllSche(new SearchCriteria("time", "18:00pm"));

        model.addAttribute("empList", empList);
        model.addAttribute("scheList1", scheList1);
        model.addAttribute("scheList2", scheList2);
        model.addAttribute("scheList3", scheList3);
        model.addAttribute("scheList4", scheList4);
        model.addAttribute("scheList5", scheList5);
        model.addAttribute("scheList6", scheList6);

        return "/emp/main";
    }

    @GetMapping("/regist")
    public String registPage() {

        return "/emp/regist";
    }

    @PostMapping("/regist")
    public String empRegist(EmpDTO empDTO, PhysicalDTO physicalDTO, EmployeeDTO employeeDTO, RedirectAttributes rttr,
                            @RequestParam MultipartFile picFile, @RequestParam String qualWrite,
                            @RequestParam String address1, @RequestParam String address2) {

        System.out.println("picFile = " + picFile);
        System.out.println(picFile.isEmpty());

        if (!picFile.isEmpty()) {
            String root = "src/main/resources/static";
            String filePath = root + "/uploadFiles";
            File dir = new File(filePath);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String originFileName = picFile.getOriginalFilename();
            System.out.println("originFileName = " + originFileName);
            String ext = originFileName.substring(originFileName.lastIndexOf("."));
            System.out.println("ext = " + ext);

            String savedName = UUID.randomUUID() + ext;
            System.out.println("savedName = " + savedName);

            try {
                picFile.transferTo(new File(filePath + "/" + savedName));
                empDTO.setPic("/uploadFiles/" +savedName);
//                picFile.transferTo(new File(filePath + "/" + originFileName));
//                model.addAttribute("message", "파일 업로드 완료!");
            } catch (Exception e) {
//                model.addAttribute("message", "파일 업로드 실패!");
                e.printStackTrace();
            }
        } else {
            empDTO.setPic("/uloadFiles/default-user.png");
        }

        int code = empService.findLastCode();

        if (empDTO.getBirth().isEmpty()) {
            empDTO.setBirth("2000-01-01");
        }

        if (!qualWrite.isEmpty()) {
            if (employeeDTO.getQual() != null) {
                String qual = employeeDTO.getQual() + "," + qualWrite;
                employeeDTO.setQual(qual);
            } else {
                employeeDTO.setQual(qualWrite);
            }
        }

        empDTO.setRole("직원");
        empDTO.setAddress(address1 + " " + address2);
        empDTO.setCode(code + 1);
        physicalDTO.setCode(code + 1);
        employeeDTO.setCode(code + 1);

        System.out.println("empDTO = " + empDTO);
        System.out.println("physicalDTO = " + physicalDTO);
        System.out.println("employeeDTO = " + employeeDTO);

        empService.registNewEmp(empDTO, physicalDTO, employeeDTO);

        return "redirect:/emp/main";
    }

    @GetMapping("/search")
    public String empSearch(Model model) {

        List<EmpDTO> empList = empService.selectAllEmp();

        model.addAttribute("empList", empList);

        return "/emp/search";
    }

    @GetMapping("/result")
    public String empResult(Model model, @RequestParam String search, @RequestParam String category, HttpSession session) {

        System.out.println("search = " + search);
        System.out.println("category = " + category);
        System.out.println("model = " + model);

        EmpTotDTO emp = empService.searchBy(new SearchCriteria(category, search));
        List<EmpDTO> empList = empService.selectAllEmp();

        session.setAttribute("searched", emp.getCode());

        model.addAttribute("emp", emp);
        model.addAttribute("empList", empList);

        return "/emp/result";
    }

    @GetMapping("/update")
    public String empUpdate(HttpSession session, Model model) {

        int code = (int) session.getAttribute("searched");
        System.out.println("code = " + code);
        String text = Integer.toString(code);
        System.out.println("text = " + text);

        EmpTotDTO emp = empService.searchBy(new SearchCriteria("code", text));
        System.out.println("emp = " + emp);

        model.addAttribute("emp", emp);

        return "/emp/update";
    }

//    @PostMapping("/update")
//    public String empUpdate(EmpDTO empDTO, PhysicalDTO physicalDTO, EmployeeDTO employeeDTO,
//                            HttpSession session) {
//
//        int code = (int) session.getAttribute("searched");
//        System.out.println("updatecode = " + code);
//
//        empDTO.setCode(code);
//        physicalDTO.setCode(code);
//        employeeDTO.setCode(code);
//
//        System.out.println("empDTO = " + empDTO);
//        System.out.println("physicalDTO = " + physicalDTO);
//        System.out.println("employeeDTO = " + employeeDTO);
//
//        empService.updateEmp(empDTO, physicalDTO, employeeDTO);
//
//        return "redirect:/emp/detail";
//    }

    @PostMapping("detail")
    public String empDetail(EmpDTO empDTO, PhysicalDTO physicalDTO, EmployeeDTO employeeDTO,
                            HttpSession session, Model model, @RequestParam MultipartFile picFile,
                            @RequestParam String address1, @RequestParam String address2) {

        if (!picFile.isEmpty()) {
            String root = "src/main/resources/static";
            String filePath = root + "/uploadFiles";
            File dir = new File(filePath);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String originFileName = picFile.getOriginalFilename();
            System.out.println("originFileName = " + originFileName);
            String ext = originFileName.substring(originFileName.lastIndexOf("."));
            System.out.println("ext = " + ext);

            String savedName = UUID.randomUUID() + ext;
            System.out.println("savedName = " + savedName);

            try {
                picFile.transferTo(new File(filePath + "/" + savedName));
                empDTO.setPic("/uploadFiles/" +savedName);
//                picFile.transferTo(new File(filePath + "/" + originFileName));
//                model.addAttribute("message", "파일 업로드 완료!");
            } catch (Exception e) {
//                model.addAttribute("message", "파일 업로드 실패!");
                e.printStackTrace();
            }
        }

        int code = (int) session.getAttribute("searched");
        String text = Integer.toString(code);

        System.out.println("address1 = " + address1);
        System.out.println("address2 = " + address2);

        if (address1 != "") {
            String address = address1 + " " + address2;
            System.out.println(address);
            empDTO.setAddress(address);
        }

        empDTO.setCode(code);
        physicalDTO.setCode(code);
        employeeDTO.setCode(code);

        System.out.println("empDTO = " + empDTO);
        System.out.println("physicalDTO = " + physicalDTO);
        System.out.println("employeeDTO = " + employeeDTO);

        empService.updateEmp(empDTO, physicalDTO, employeeDTO);

        EmpTotDTO emp = empService.searchBy(new SearchCriteria("code", text));
        List<EmpDTO> empList = empService.selectAllEmp();

        System.out.println("emp = " + emp);

        model.addAttribute("emp", emp);
        model.addAttribute("empList", empList);

        return "redirect:/emp/main";
    }

    @GetMapping("/detail")
    public String empDetail(HttpSession session, Model model) {

        System.out.println("getDetail");

        int code = (int) session.getAttribute("searched");
        String text = Integer.toString(code);

        EmpTotDTO emp = empService.searchBy(new SearchCriteria("code", text));
        List<EmpDTO> empList = empService.selectAllEmp();

        System.out.println("emp = " + emp);

        model.addAttribute("emp", emp);
        model.addAttribute("empList", empList);

        return "/emp/detail";
    }

    @PostMapping("/remove")
    public String empRemove(HttpSession session) {

        int code = (int) session.getAttribute("searched");
        empService.removeEmp(code);

        return "redirect:/emp/main";
    }

    @GetMapping("/test")
    public String empTest() {

        return "/emp/test";
    }
}
