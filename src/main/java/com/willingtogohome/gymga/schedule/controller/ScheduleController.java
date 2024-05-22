package com.willingtogohome.gymga.schedule.controller;

import com.willingtogohome.gymga.schedule.exception.ScheduleNotFoundException;
import com.willingtogohome.gymga.schedule.model.dto.ClassDTO;
import com.willingtogohome.gymga.schedule.model.dto.EmpDTO;
import com.willingtogohome.gymga.schedule.model.dto.ScheduleAndClassAndUserAndPassDTO;
import com.willingtogohome.gymga.schedule.model.dto.ScheduleDTO;
import com.willingtogohome.gymga.schedule.model.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

//    @GetMapping(value = {"/", "/main"})
//    public String main() {
//        return "main";
//    }

//     일정 전체 조회
    @GetMapping(value = "/schedule/schedulemain")
    public String scheduleMain(Model model) {

        List<ScheduleAndClassAndUserAndPassDTO> allList = scheduleService.findAll();

        if(allList.isEmpty()) {
            throw new ScheduleNotFoundException("일정이 없습니다.");
        }
        model.addAttribute("allList", allList);
        System.out.println("allList = " + allList);

        return "schedule/schedulemain";
    }

    // ScheRunDate 값 찾기
    @GetMapping(value = "/schedule/scherundate", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<ScheduleAndClassAndUserAndPassDTO> findAllScheRunDate() {

        List<ScheduleAndClassAndUserAndPassDTO> result = scheduleService.findAllScheRunDate();

        scheduleService.findAllScheRunDate().forEach(System.out::println);

        if(result.isEmpty()) {
            throw new ScheduleNotFoundException("해당 날짜에 일정이 없습니다.");
        }

        return result;
    }

    // 일정으로 페이지 가기 ?
    @GetMapping("schedule/list/{scheRunDate}")
    public String findByScheRunDate(@PathVariable("scheRunDate") LocalDate scheRunDate, Model model) {
        List<ScheduleAndClassAndUserAndPassDTO> scheduleListByRunDate = scheduleService.findByScheRunDate(scheRunDate);
        model.addAttribute("scheduleListByRunDate", scheduleListByRunDate);
        System.out.println("scheduleListByRunDate = " + scheduleListByRunDate);
        return "schedule/schedulemain";
    }

    @GetMapping("/schedule/scheduleregist")
    public void registPage() {
    }

    @GetMapping(value = "/schedule/teacher", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<EmpDTO> findTeacherList() {

        List<EmpDTO> teachers = scheduleService.findAllTeacher();

        scheduleService.findAllTeacher().forEach(System.out::println);

        if(teachers.isEmpty()) {
            throw  new ScheduleNotFoundException("강사를 찾을 수 없습니다.");
        }

        return teachers;
    }

    @GetMapping(value ="/schedule/className", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<ClassDTO> findClassNameList() {

        List<ClassDTO> classList = scheduleService.findAllClassName();
        scheduleService.findAllClassName().forEach(System.out::println);
            if(classList.isEmpty()) {
                throw new ScheduleNotFoundException("강의를 찾을 수 없습니다.");
            }
        return classList;
    }

    @PostMapping("/schedule/scheduleregistPt")
    public String registNewPtSchedule(ScheduleDTO newSchedule, RedirectAttributes redirectAttributes) {

        scheduleService.registNewPtSchedule(newSchedule);

        redirectAttributes.addFlashAttribute("successMessage", "일정 등록 성공");

        return "schedule/schedulemain";
    }
    @PostMapping("/schedule/scheduleregistgx")
    public String registNewGxSchedule(ScheduleDTO newSchedule, RedirectAttributes redirectAttributes) {

        scheduleService.registNewGxSchedule(newSchedule);

        redirectAttributes.addFlashAttribute("successMessage", "일정 등록 성공");

        return "schedule/schedulemain";
    }


    // JOIN을 활용한 Schedule 전체 조회(className, empName, memberName, passTotal, passUse)
    @GetMapping("/schedule/schedulelist")
    public String findAll(Model model) {
        List<ScheduleAndClassAndUserAndPassDTO> allList = scheduleService.findAll();
        model.addAttribute("allList", allList);
        System.out.println("allList = " + allList);

        return "schedule/schedulemain";
        // return 변경 예정
    }

    // PT 상세페이지(scheCode로 선택)
    @GetMapping("/schedule/schedulelist/{scheCode}")
    public String findByScheduleCode(@PathVariable("scheCode") int scheCode, Model model, SecurityContextHolder securityContextHolder) {
        ScheduleAndClassAndUserAndPassDTO scheduleAndClassAndUserAndPassDTO = scheduleService.findByScheCode(scheCode);
        model.addAttribute("selectOneSchedule", scheduleAndClassAndUserAndPassDTO);
        System.out.println(securityContextHolder.getContext());
        System.out.println(securityContextHolder.getContext().getAuthentication());
        System.out.println(securityContextHolder.getContext().getAuthentication().getName());
        System.out.println("변경할데이터조회 = " + scheduleAndClassAndUserAndPassDTO);

        return "schedule/scheduledetail";
    }

    // GX 특정페이지로 보내기(regDate 참조?)
    @GetMapping("/schedule/schedulegx/{scheCode}/{scheRegDate}")
    public String findGxByRegDate(@PathVariable("scheCode") int scheCode,
                                  @PathVariable("scheRegDate") LocalDateTime scheRegDate,
                                  Model model) {

        ScheduleAndClassAndUserAndPassDTO gxList = scheduleService.findGxList(scheCode);
        model.addAttribute("findGxList", gxList);

        List<ScheduleAndClassAndUserAndPassDTO> findGxByRegDate = scheduleService.findGxByRegDate(scheRegDate);
        model.addAttribute("findGxByRegDate", findGxByRegDate);
        System.out.println("findGxByRegDate = " + findGxByRegDate);

        return "schedule/scheduledetailgx";
    }

//    @GetMapping("schedule/list/{scheRunDate}")
//    public String findByScheRunDate(@PathVariable("scheRunDate") LocalDate scheRunDate, Model model) {
//        List<ScheduleAndClassAndUserAndPassDTO> scheduleListByRunDate = scheduleService.findByScheRunDate(scheRunDate);
//        model.addAttribute("scheduleListByRunDate", scheduleListByRunDate);
//        System.out.println("scheduleListByRunDate = " + scheduleListByRunDate);
//        return "schedule/schedulemain";
//    }

//    @GetMapping("/schedule/scheduleupdate")
//    public void updatePage(){}

    // 일정변경

    @GetMapping("/schedule/scheduleupdate/{scheCode}")
    public String updateSchedule(@PathVariable("scheCode") int scheCode, Model model) {
        ScheduleAndClassAndUserAndPassDTO scheduleAndClassAndUserAndPassDTO = scheduleService.findByScheCode(scheCode);
        model.addAttribute("selectOneSchedule", scheduleAndClassAndUserAndPassDTO);
        System.out.println("scheduleAndClassAndUserAndPassDTO = " + scheduleAndClassAndUserAndPassDTO);

        return "schedule/scheduleupdate";
    }

    @PostMapping("/schedule/scheduleupdate/{scheCode}")
    public String updateSchedule(ScheduleDTO scheduleDTO, RedirectAttributes redirectAttributes) {

        scheduleService.updateSchedule(scheduleDTO);

        redirectAttributes.addFlashAttribute("successMessage", "일정 변경 성공");

        return "redirect:/schedule/schedulelist/{scheCode}";
    }

    // GX 일정 변경 정보
    @PostMapping("/schedule/scheduleupdate/{scheCode}/{scheRegDate}")
    public String updateSchedule(ScheduleDTO scheduleDTO) {
        scheduleService.updateGxSchedule(scheduleDTO);

        return "redirect:/schedule/schedulegx/{scheCode}/{scheRegDate}";
    }
    // 출결변경(출석버튼)-P.T
    @GetMapping("/schedule/attenupdate/{scheCode}")
    public String updateAtten(@PathVariable("scheCode") int scheCode) {
        scheduleService.updateAtten(scheCode);
        return "redirect:/schedule/schedulelist/{scheCode}";
    }

    // 출결변경(출석버튼)-G.X redirect:에 scheRegDate를 넣어줘야함
    @GetMapping("/schedule/gxattenupdate/{scheCode}/{scheRegDate}")
    public String updateAttenGx(@PathVariable("scheCode") int scheCode) {
        scheduleService.updateAtten(scheCode);
        return "redirect:/schedule/schedulegx/{scheCode}/{scheRegDate}";
    }

    // 출결변경(결석버튼)
    @GetMapping("/schedule/absentupdate/{scheCode}")
    public String updateAbsent(@PathVariable("scheCode") int scheCode) {
        scheduleService.updateAbsent(scheCode);
        return "redirect:/schedule/schedulelist/{scheCode}";
    }

    @GetMapping("/schedule/gxabsentupdate/{scheCode}/{scheRegDate}")
    public String updateAbsentGx(@PathVariable("scheCode") int scheCode) {
        scheduleService.updateAbsent(scheCode);
        return "redirect:/schedule/schedulegx/{scheCode}/{scheRegDate}";
    }

    // 취소버튼(롤백개념)
    @GetMapping("/schedule/cancelupdate/{scheCode}")
    public String updateCancel(@PathVariable("scheCode") int scheCode){
        scheduleService.updateCancel(scheCode);
        return "redirect:/schedule/schedulelist/{scheCode}";
    }

    @GetMapping("/schedule/gxcancelupdate/{scheCode}/{scheRegDate}")
    public String updateCancelGx(@PathVariable("scheCode") int scheCode) {
        scheduleService.updateCancel(scheCode);
        return "redirect:/schedule/schedulegx/{scheCode}/{scheRegDate}";
    }


    // Sche_atten 값 찾기(출결상태 수정)
    @GetMapping(value = "/schedule/scheatten/{scheCode}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ScheduleAndClassAndUserAndPassDTO findScheAtten(@PathVariable int scheCode) {

        ScheduleAndClassAndUserAndPassDTO scheduleAndClassAndUserAndPassDTO = scheduleService.findScheAtten(scheCode);
        System.out.println("scheduleAndClassAndUserAndPassDTO = " + scheduleAndClassAndUserAndPassDTO);

        return scheduleAndClassAndUserAndPassDTO;
    }

    @GetMapping(value = "/schedule/scheatten/{scheCode}/{scheRegDate}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ScheduleAndClassAndUserAndPassDTO findGxScheAtten(@PathVariable int scheCode) {

        ScheduleAndClassAndUserAndPassDTO scheduleAndClassAndUserAndPassDTO = scheduleService.findScheAtten(scheCode);
        System.out.println("scheduleAndClassAndUserAndPassDTO = " + scheduleAndClassAndUserAndPassDTO);

        return scheduleAndClassAndUserAndPassDTO;
    }

    @GetMapping("/api/loggedInUser")
    public ResponseEntity<String> getLoggedInUser(SecurityContextHolder securityContextHolder) {

        int userCode = Integer.parseInt(securityContextHolder.getContext().getAuthentication().getName());
        String userName = scheduleService.findUserName(userCode);

//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username;
//
//        if (principal instanceof UserDetails) {
//            username = ((UserDetails) principal).getUsername();
//        } else {
//            username = principal.toString();
//        }

        return ResponseEntity.ok(userName);
    }












}
