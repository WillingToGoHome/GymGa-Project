package com.willingtogohome.gymga.schedule.controller;

import com.willingtogohome.gymga.schedule.model.dto.ScheduleDTO;
import com.willingtogohome.gymga.schedule.model.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;
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

    @GetMapping("/schedule/schedulemain")
    public String scheduleMain(Model model) {

        List<ScheduleDTO> scheduleList = scheduleService.findAllSchedule();

        for(ScheduleDTO schedules : scheduleList) {
            System.out.println("schedules = " + schedules);
        }

        model.addAttribute("scheduleList", scheduleList);

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        cal.set(year, month-1, 1);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(year + "년 " + month + "월 " + dayOfWeek);

        return "schedule/schedulemain";

    }





}
