package com.willingtogohome.gymga.schedule.model.service;

import com.willingtogohome.gymga.schedule.model.dao.ScheduleMapper;
import com.willingtogohome.gymga.schedule.model.dto.ClassDTO;
import com.willingtogohome.gymga.schedule.model.dto.EmpDTO;
import com.willingtogohome.gymga.schedule.model.dto.ScheduleAndClassAndUserAndPassDTO;
import com.willingtogohome.gymga.schedule.model.dto.ScheduleDTO;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleMapper scheduleMapper;

    public ScheduleService(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }


    // 일정 목록보기
    // 일정 상세보기
    // 일정 수정하기
    // 일정 삭제하기 ?
    // 일정의 개수 조회하기
    // 달력에 존재하는 일정 조회

    // 모든 일정 보기
    public List<ScheduleDTO> findAllSchedule() {

        return scheduleMapper.findAllSchedule();
    }

    // 강사 목록 선택
    public List<EmpDTO> findAllTeacher() {

        return scheduleMapper.findAllTeacher();
    }

    // 일정 추가하기
    public void registNewPtSchedule(ScheduleDTO newSchedule) {
        scheduleMapper.registNewPtSchedule(newSchedule);
    }

    public void registNewGxSchedule(ScheduleDTO newSchedule) {
        scheduleMapper.registNewGxSchedule(newSchedule);
    }

    public List<ScheduleAndClassAndUserAndPassDTO> findAll() {

        return scheduleMapper.findAll();
    }

    public void updateSchedule(ScheduleDTO scheduleDTO) {
        scheduleMapper.updateSchedule(scheduleDTO);
    }


    // 일정코드로 찾기
    public ScheduleAndClassAndUserAndPassDTO findByScheCode(int scheCode) {

        return scheduleMapper.findByScheCode(scheCode);
    }


    public void updateAtten(int scheCode) {

        scheduleMapper.updateAtten(scheCode);
    }

    public void updateAbsent(int scheCode) {
        scheduleMapper.updateAbsent(scheCode);
    }

    public void updateCancel(int scheCode) {
        scheduleMapper.updateCancel(scheCode);
    }


    public ScheduleAndClassAndUserAndPassDTO findScheAtten(int scheCode) {
        return scheduleMapper.findScheAtten(scheCode);
    }


    public List<ScheduleAndClassAndUserAndPassDTO> findAllScheRunDate() {
        return scheduleMapper.findAllScheRunDate();
    }


    public List<ScheduleAndClassAndUserAndPassDTO> findByScheRunDate(Date scheRunDate) {

        return scheduleMapper.findAllByScheRunDate(scheRunDate);
    }

    public List<ClassDTO> findAllClassName() {
        return scheduleMapper.findAllClassName();
    }


    public List<ScheduleAndClassAndUserAndPassDTO> findByClassCode(String classCode) {
        return scheduleMapper.findByClassCode(classCode);
    }

    public ScheduleAndClassAndUserAndPassDTO findGxList(int scheCode) {
        return scheduleMapper.findGxList(scheCode);
    }

    public List<ScheduleAndClassAndUserAndPassDTO> findGxByRegDate(LocalDateTime scheRegDate) {
        return scheduleMapper.findGxByRegDate(scheRegDate);
    }
}
