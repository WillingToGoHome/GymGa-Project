package com.willingtogohome.gymga.schedule.controller;

import com.willingtogohome.gymga.schedule.model.dto.ScheduleDTO;
import com.willingtogohome.gymga.schedule.model.service.ScheduleService;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
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
    public List<UserDTO> findTeacherList() {

        scheduleService.findAllTeacher().forEach(System.out::println);

        return scheduleService.findAllTeacher();
    }
    @PostMapping("/schedule/scheduleregist")
    public String registSchedule(ScheduleDTO newSchedule, RedirectAttributes redirectAttributes) {

        scheduleService.registNewSchedule(newSchedule);

        redirectAttributes.addFlashAttribute("successMessage", "일정 등록 성공");

        return "redirect:/schedule/schedulemain";
    }







}
