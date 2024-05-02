package com.willingtogohome.gymga.schedule.controller;

import com.willingtogohome.gymga.schedule.model.dto.ScheduleDTO;
import com.willingtogohome.gymga.schedule.model.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("schedule/schedulemain")
    public String scheduleMain(Model model) {

        List<ScheduleDTO> scheduleList = scheduleService.findAllSchedule();

        for(ScheduleDTO schedules : scheduleList) {
            System.out.println("schedules = " + schedules);
        }

        model.addAttribute("scheduleList", scheduleList);

        return " schedule/schedulemain";

    }





}
