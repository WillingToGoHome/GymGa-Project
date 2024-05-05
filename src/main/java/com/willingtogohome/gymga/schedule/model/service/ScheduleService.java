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

    // 일정 추가하기


    // 일정 목록보기
    // 일정 상세보기
    // 일정 수정하기
    // 일정 삭제하기 ?
    // 일정의 개수 조회하기
    // 달력에 존재하는 일정 조회

    public List<ScheduleDTO> findAllSchedule() {

        return scheduleMapper.findAllSchedule();
    }
}
