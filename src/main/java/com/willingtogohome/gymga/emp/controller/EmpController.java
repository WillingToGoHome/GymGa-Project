package com.willingtogohome.gymga.emp.controller;

import com.willingtogohome.gymga.emp.model.dto.*;
import com.willingtogohome.gymga.emp.model.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/emp")
public class EmpController {

    private final EmpService empService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EmpController(EmpService empService, PasswordEncoder passwordEncoder) {
        this.empService = empService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = {"/", "/main"})
    public String empMain(HttpSession session, Model model, SecurityContextHolder securityContextHolder) {

        System.out.println("get : /emp/ or /emp/main");

        String name = securityContextHolder.getContext().getAuthentication().getName();

        EmpTotDTO emp = empService.selectBy(new SearchCriteria("name", name));
        List<EmpDTO> empList = empService.selectAllEmp();

        String code = Integer.toString(emp.getCode());
        String role = emp.getRole();

        if (role.equals("ADMIN")) {
            List<ScheDTO> scheList1 = empService.selectAllSche(new SearchCriteria("0", "8:00am"));
            List<ScheDTO> scheList2 = empService.selectAllSche(new SearchCriteria("0", "10:00am"));
            List<ScheDTO> scheList3 = empService.selectAllSche(new SearchCriteria("0", "12:00pm"));
            List<ScheDTO> scheList4 = empService.selectAllSche(new SearchCriteria("0", "14:00pm"));
            List<ScheDTO> scheList5 = empService.selectAllSche(new SearchCriteria("0", "16:00pm"));
            List<ScheDTO> scheList6 = empService.selectAllSche(new SearchCriteria("0", "18:00pm"));
            model.addAttribute("scheList1", scheList1);
            model.addAttribute("scheList2", scheList2);
            model.addAttribute("scheList3", scheList3);
            model.addAttribute("scheList4", scheList4);
            model.addAttribute("scheList5", scheList5);
            model.addAttribute("scheList6", scheList6);
        } else {
            session.setAttribute("searched", Integer.parseInt(code));
            List<ScheDTO> scheList1 = empService.selectAllSche(new SearchCriteria(code, "8:00am"));
            List<ScheDTO> scheList2 = empService.selectAllSche(new SearchCriteria(code, "10:00am"));
            List<ScheDTO> scheList3 = empService.selectAllSche(new SearchCriteria(code, "12:00pm"));
            List<ScheDTO> scheList4 = empService.selectAllSche(new SearchCriteria(code, "14:00pm"));
            List<ScheDTO> scheList5 = empService.selectAllSche(new SearchCriteria(code, "16:00pm"));
            List<ScheDTO> scheList6 = empService.selectAllSche(new SearchCriteria(code, "18:00pm"));
            model.addAttribute("scheList1", scheList1);
            model.addAttribute("scheList2", scheList2);
            model.addAttribute("scheList3", scheList3);
            model.addAttribute("scheList4", scheList4);
            model.addAttribute("scheList5", scheList5);
            model.addAttribute("scheList6", scheList6);
        }
//
        model.addAttribute("emp", emp);
        model.addAttribute("empList", empList);

        return "/emp/main";
    }

    @GetMapping("/regist")
    public String empRegist(Model model) {

        System.out.println("get : /emp/regist");

        List<EmpDTO> userIDList = empService.selectAllUserID();

        String[] idList = new String[userIDList.size()];
        int i = 0;
        for (EmpDTO userId : userIDList) {
            idList[i++] = userId.getId();
        }

        model.addAttribute("idList", idList);

        return "/emp/regist";
    }

    @PostMapping("/regist")
    public String empRegist(@RequestParam MultipartFile picFile,
                            EmpDTO empDTO, PhysicalDTO physicalDTO, EmployeeDTO employeeDTO,
                            @RequestParam String address1, @RequestParam String address2,
                            @RequestParam String qualWrite) {

        System.out.println("post : /emp/regist");

        if (!picFile.isEmpty()) {
            String root = "src/main/resources/static";
            String filePath = root + "/uploadFiles";
            File dir = new File(filePath);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String originFileName = picFile.getOriginalFilename();
            String ext = originFileName.substring(originFileName.lastIndexOf("."));

            String savedName = UUID.randomUUID() + ext;

            try {
                picFile.transferTo(new File(filePath + "/" + savedName));
                empDTO.setPic(savedName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            empDTO.setPic("default-user.png");
        }

        int code = empService.findLastCode();

        if (!qualWrite.isEmpty()) {
            if (employeeDTO.getQual() != null) {
                String qual = employeeDTO.getQual() + "," + qualWrite;
                employeeDTO.setQual(qual);
            } else {
                employeeDTO.setQual(qualWrite);
            }
        } else if (employeeDTO.getQual() == null) {
            employeeDTO.setQual("");
        }

        if (!address1.isEmpty()) {
            if (!address2.isEmpty()) {
                empDTO.setAddress(address1 + " " + address2);
            } else {
                empDTO.setAddress(address1);
            }
        } else {
            empDTO.setAddress("");
        }

        String originPwd = empDTO.getPwd();
        String savedPwd = passwordEncoder.encode(originPwd);

        empDTO.setRole("USER");
        empDTO.setPwd(savedPwd);
        empDTO.setCode(code + 1);
        physicalDTO.setCode(code + 1);
        employeeDTO.setCode(code + 1);

//        System.out.println("empDTO = " + empDTO);
//        System.out.println("physicalDTO = " + physicalDTO);
//        System.out.println("employeeDTO = " + employeeDTO);

        empService.registNewEmp(empDTO, physicalDTO, employeeDTO);

        return "redirect:/emp/main";
    }

    @GetMapping("/search")
    public String empSearch(HttpSession session, Model model) {

        System.out.println("get : /emp/search");

        List<EmpDTO> empList = empService.selectAllEmp();

        model.addAttribute("empList", empList);

        return "/emp/search";
    }

    @GetMapping("/result")
    public String empResult(HttpSession session,
                            @RequestParam String search,
                            @RequestParam String category,
                            Model model) {

        System.out.println("get : /emp/result");

        List<EmpTotDTO> searchedEmps = empService.searchBy(new SearchCriteria(category, search));
        List<EmpDTO> empList = empService.selectAllEmp();

        model.addAttribute("empList", empList);

        if (searchedEmps.size() == 0) {
            return "/emp/searchfail";
        } else if (searchedEmps.size() == 1) {
            model.addAttribute("emp", searchedEmps.get(0));
            session.setAttribute("searched", searchedEmps.get(0).getCode());
        } else if (searchedEmps.size() >= 2) {
            model.addAttribute("searchedEmps", searchedEmps);
            return "/emp/searchlist";
        }

        return "/emp/result";
    }

    @GetMapping("/searchfail")
    public String searchFail() {

        return "/emp/searchFail";
    }

    @GetMapping("/searchlist")
    public String searchList() {

        return "/emp/searchList";
    }

    @GetMapping("/update")
    public String empUpdate(HttpSession session, Model model) {

        System.out.println("get : /emp/update");

        int code = (int) session.getAttribute("searched");
        String text = Integer.toString(code);

        EmpTotDTO emp = empService.selectBy(new SearchCriteria("code", text));
        List<EmpDTO> empList = empService.selectAllEmp();

        String sCode = Integer.toString(emp.getCode());
        String role = emp.getRole();

        if (role.equals("USER")) {
                        List<ScheDTO> scheList1 = empService.selectAllSche(new SearchCriteria(sCode, "8:00am"));
            List<ScheDTO> scheList2 = empService.selectAllSche(new SearchCriteria(sCode, "10:00am"));
            List<ScheDTO> scheList3 = empService.selectAllSche(new SearchCriteria(sCode, "12:00pm"));
            List<ScheDTO> scheList4 = empService.selectAllSche(new SearchCriteria(sCode, "14:00pm"));
            List<ScheDTO> scheList5 = empService.selectAllSche(new SearchCriteria(sCode, "16:00pm"));
            List<ScheDTO> scheList6 = empService.selectAllSche(new SearchCriteria(sCode, "18:00pm"));
            model.addAttribute("scheList1", scheList1);
            model.addAttribute("scheList2", scheList2);
            model.addAttribute("scheList3", scheList3);
            model.addAttribute("scheList4", scheList4);
            model.addAttribute("scheList5", scheList5);
            model.addAttribute("scheList6", scheList6);
        }

        String[] quals = emp.getEmployeeDTO().getQual().split(",");

        model.addAttribute("emp", emp);
        model.addAttribute("quals", quals);
        model.addAttribute("empList", empList);

        return "/emp/update";
    }

    @PostMapping("detail")
    public String empDetail(HttpSession session,
                            @RequestParam MultipartFile picFile,
                            EmpDTO empDTO, PhysicalDTO physicalDTO, EmployeeDTO employeeDTO,
                            @RequestParam String address1, @RequestParam String address2,
                            @RequestParam String qualEtc, @RequestParam String qualWrite,
                            Model model) {

        System.out.println("post : /emp/detail");

        int code = (int) session.getAttribute("searched");
        String text = Integer.toString(code);

        EmpTotDTO emp = empService.selectBy(new SearchCriteria("code", text));

        if (!picFile.isEmpty()) {
            String root = "src/main/resources/static";
            String filePath = root + "/uploadFiles";
            File dir = new File(filePath);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String originFileName = picFile.getOriginalFilename();
            String ext = originFileName.substring(originFileName.lastIndexOf("."));

            String savedName = UUID.randomUUID() + ext;

            try {
                picFile.transferTo(new File(filePath + "/" + savedName));
                String path = "C:/Lecture/GymGa-Project/src/main/resources/static/uploadFiles/";
                String originFile = emp.getPic();
//
                File deleteFile = new File(path + originFile);

                if (!originFile.equals("default-user.png")) {
                    if (deleteFile.exists()) {
                        deleteFile.delete();
                    }
                }

                empDTO.setPic(savedName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!address1.isEmpty()) {
            empDTO.setAddress(address1 + " " + address2);
        }

        if (!qualWrite.isEmpty()) {
            if (employeeDTO.getQual() != null) {
                String qual = employeeDTO.getQual() + "," + qualWrite;
                employeeDTO.setQual(qual);
            } else {
                employeeDTO.setQual(qualWrite);
            }
        } else {
            if (!qualEtc.isEmpty()) {
                if (employeeDTO.getQual() != null) {
                    String qual = employeeDTO.getQual() + "," + qualEtc;
                    employeeDTO.setQual(qual);
                } else {
                    employeeDTO.setQual(qualEtc);
                }
            }
        }

        if (!empDTO.getPwd().isEmpty()) {

            String originPwd = empDTO.getPwd();
            String savedPwd = passwordEncoder.encode(originPwd);

            empDTO.setPwd(savedPwd);
        }

        empDTO.setCode(code);
        physicalDTO.setCode(code);
        employeeDTO.setCode(code);

//        System.out.println("empDTO = " + empDTO);
//        System.out.println("physicalDTO = " + physicalDTO);
//        System.out.println("employeeDTO = " + employeeDTO);

        empService.updateEmp(empDTO, physicalDTO, employeeDTO);


        List<EmpDTO> empList = empService.selectAllEmp();

        model.addAttribute("emp", emp);
        model.addAttribute("empList", empList);

        return "redirect:/emp/detail";
    }

    @GetMapping("/detail")
    public String empDetail(HttpSession session, Model model) {

        System.out.println("get : /emp/detail");

        int code = (int) session.getAttribute("searched");
        String text = Integer.toString(code);

        EmpTotDTO emp = empService.selectBy(new SearchCriteria("code", text));
        List<EmpDTO> empList = empService.selectAllEmp();

        model.addAttribute("emp", emp);
        model.addAttribute("empList", empList);

        return "/emp/detail";
    }

    @GetMapping("/detail/{code}")
    public String selectEmpDetail(HttpSession session, Model model,
                                  @PathVariable int code) {

        System.out.println("get : /emp/detail/{code}");

        String text = Integer.toString(code);
        session.setAttribute("searched", code);

        EmpTotDTO emp = empService.selectBy(new SearchCriteria("code", text));
        List<EmpDTO> empList = empService.selectAllEmp();

        model.addAttribute("emp", emp);
        model.addAttribute("empList", empList);

        return "/emp/detail";
    }

    @PostMapping("/remove")
    public String empRemove(HttpSession session) {

        System.out.println("post : /emp/remove");

        int code = (int) session.getAttribute("searched");
        empService.removeEmp(code);

        return "redirect:/emp/main";
    }

    @GetMapping("/send")
    public void sendError() {

        throw new NullPointerException();
    }

    @ExceptionHandler(SQLException.class)
    public String sqlException(SQLException exception, Model model) {

        String message = "자료 입력에 문제가 발생했습니다";

        if (exception.toString().contains("salary")) {
            message = "기본급 입력에 문제가 발생했습니다";
        }

        model.addAttribute("message", message);
        model.addAttribute("exception", exception);

        return "/emp/error";
    }

    @ExceptionHandler(UncategorizedSQLException.class)
    public String uncategorizedSqlException(UncategorizedSQLException exception, Model model) {

        String message = "자료 입력에 문제가 발생했습니다";

        if (exception.toString().contains("salary")) {
            message = "기본급 입력에 문제가 발생했습니다";
        }

        model.addAttribute("message", message);
        model.addAttribute("exception", exception);

        return "/emp/error";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerException(NullPointerException exception, Model model) {

        String message = "자료를 불러오는데 문제가 발생했습니다";

        model.addAttribute("message", message);
        model.addAttribute("exception", exception);

        return "/emp/error";
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception exception, Model model) {

        String message = "알 수 없는 문제가 발생했습니다";

        model.addAttribute("message", message);
        model.addAttribute("exception", exception);

        return "/emp/error";
    }
}
