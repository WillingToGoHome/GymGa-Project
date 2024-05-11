package com.willingtogohome.gymga.schedule.model.dao;

import com.willingtogohome.gymga.schedule.model.dto.EmpDTO;
import com.willingtogohome.gymga.schedule.model.dto.ScheduleAndClassAndUserAndPassDTO;
import com.willingtogohome.gymga.schedule.model.dto.ScheduleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    List<ScheduleDTO> findAllSchedule();


    // 강사 찾기(옵션 선택용)
    List<EmpDTO> findAllTeacher();
    void registNewSchedule(ScheduleDTO newSchedule);


    List<ScheduleAndClassAndUserAndPassDTO> findAll();

    void updateSchedule(ScheduleDTO scheduleDTO);

    ScheduleAndClassAndUserAndPassDTO findByScheCode(int scheCode);

    void updateAtten(int scheCode);

    void updateAbsent(int scheCode);

    void updateCancel(int scheCode);

}
