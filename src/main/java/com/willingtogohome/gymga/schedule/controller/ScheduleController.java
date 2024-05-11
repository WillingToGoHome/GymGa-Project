package com.willingtogohome.gymga.schedule.controller;

import com.willingtogohome.gymga.schedule.model.dto.EmpDTO;
import com.willingtogohome.gymga.schedule.model.dto.ScheduleAndClassAndUserAndPassDTO;
import com.willingtogohome.gymga.schedule.model.dto.ScheduleDTO;
import com.willingtogohome.gymga.schedule.model.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping(value = {"/", "/main"})
    public String main() {
        return "main";
    }

    // 일정 전체 조회
    @GetMapping("/schedule/schedulemain")
    public String scheduleMain(Model model) {

        List<ScheduleDTO> scheduleList = scheduleService.findAllSchedule();

        for(ScheduleDTO schedules : scheduleList) {
            System.out.println("schedules = " + schedules);
        }

        model.addAttribute("scheduleList", scheduleList);


        return "schedule/schedulemain";

    }

    @GetMapping("/schedule/scheduleregist")
    public void registPage() {
    }

    @GetMapping(value = "/schedule/teacher", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<EmpDTO> findTeacherList() {

        scheduleService.findAllTeacher().forEach(System.out::println);

        return scheduleService.findAllTeacher();
    }
    @PostMapping("/schedule/scheduleregist")
    public String registSchedule(ScheduleDTO newSchedule, RedirectAttributes redirectAttributes) {

        scheduleService.registNewSchedule(newSchedule);

        redirectAttributes.addFlashAttribute("successMessage", "일정 등록 성공");

        return "redirect:/schedule/schedulemain";
    }


    // JOIN을 활용한 Schedule 전체 조회(className, empName, memberName, passTotal, passUse)
    @GetMapping("/schedule/schedulelist")
    public String findAll(Model model) {
        List<ScheduleAndClassAndUserAndPassDTO> allList = scheduleService.findAll();
        model.addAttribute("allList", allList);
        System.out.println("allList = " + allList);

        return "schedule/schedulelist";
        // return 변경 예정
    }

    // 상세페이지(scheCode로 선택)
    @GetMapping("/schedule/schedulelist/{scheCode}")
    public String findByScheduleCode(@PathVariable("scheCode") int scheCode, Model model) {
        ScheduleAndClassAndUserAndPassDTO scheduleAndClassAndUserAndPassDTO = scheduleService.findByScheCode(scheCode);
        model.addAttribute("selectOneSchedule", scheduleAndClassAndUserAndPassDTO);
        System.out.println("scheduleAndClassAndUserAndPassDTO = " + scheduleAndClassAndUserAndPassDTO);

        return "schedule/scheduledetail";
    }

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

        return "redirect:/schedule/schedulelist";
    }

    // 출결변경(출석버튼)
    @GetMapping("/schedule/attenupdate/{scheCode}")
    public String updateAtten(@PathVariable("scheCode") int scheCode) {
        scheduleService.updateAtten(scheCode);
        return "redirect:/schedule/schedulelist/{scheCode}";
    }

    // 출결변경(결석버튼)
    @GetMapping("/schedule/absentupdate/{scheCode}")
    public String updateAbsent(@PathVariable("scheCode") int scheCode) {
        scheduleService.updateAbsent(scheCode);
        return "redirect:/schedule/schedulelist/{scheCode}";
    }

    // 취소버튼(롤백개념)
    @GetMapping("/schedule/cancelupdate/{scheCode}")
    public String updateCancel(@PathVariable("scheCode") int scheCode){
        scheduleService.updateCancel(scheCode);
        return "redirect:/schedule/schedulelist/{scheCode}";
    }

    // 하나의 일정 값 불러오기?
    @GetMapping(value = "/schedule/scheatten/{scheCode}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ScheduleAndClassAndUserAndPassDTO findScheAtten(@PathVariable int scheCode) {

        ScheduleAndClassAndUserAndPassDTO scheduleAndClassAndUserAndPassDTO = scheduleService.findScheAtten(scheCode);
        System.out.println("scheduleAndClassAndUserAndPassDTO = " + scheduleAndClassAndUserAndPassDTO);

        return scheduleAndClassAndUserAndPassDTO;
    }










}
