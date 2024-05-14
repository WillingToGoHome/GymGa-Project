package com.willingtogohome.gymga.schedule.model.dao;

import com.willingtogohome.gymga.schedule.model.dto.ClassDTO;
import com.willingtogohome.gymga.schedule.model.dto.EmpDTO;
import com.willingtogohome.gymga.schedule.model.dto.ScheduleAndClassAndUserAndPassDTO;
import com.willingtogohome.gymga.schedule.model.dto.ScheduleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.util.List;

@Mapper
public interface ScheduleMapper {

    List<ScheduleDTO> findAllSchedule();


    // 강사 찾기(옵션 선택용)
    List<EmpDTO> findAllTeacher();
    void registNewPtSchedule(ScheduleDTO newSchedule);

    void registNewGxSchedule(ScheduleDTO newSchedule);

    List<ScheduleAndClassAndUserAndPassDTO> findAll();

    void updateSchedule(ScheduleDTO scheduleDTO);

    ScheduleAndClassAndUserAndPassDTO findByScheCode(int scheCode);

    void updateAtten(int scheCode);

    void updateAbsent(int scheCode);

    void updateCancel(int scheCode);

    ScheduleAndClassAndUserAndPassDTO findScheAtten(int scheCode);

    List<ScheduleAndClassAndUserAndPassDTO> findAllScheRunDate();


    List<ScheduleAndClassAndUserAndPassDTO> findAllByScheRunDate(Date scheRunDate);

    List<ClassDTO> findAllClassName();


    List<ScheduleAndClassAndUserAndPassDTO> findByClassCode(String classCode);
}
