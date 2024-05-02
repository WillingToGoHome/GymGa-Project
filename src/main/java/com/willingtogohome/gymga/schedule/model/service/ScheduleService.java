package com.willingtogohome.gymga.schedule.model.service;

import com.willingtogohome.gymga.schedule.model.dao.ScheduleMapper;
import com.willingtogohome.gymga.schedule.model.dto.ScheduleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleMapper scheduleMapper;

    public ScheduleService(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    public List<ScheduleDTO> findAllSchedule() {

        return scheduleMapper.findAllSchedule();
    }
}
