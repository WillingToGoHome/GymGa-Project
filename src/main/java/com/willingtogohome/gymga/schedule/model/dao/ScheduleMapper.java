package com.willingtogohome.gymga.schedule.model.dao;

import com.willingtogohome.gymga.schedule.model.dto.ScheduleDTO;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    List<ScheduleDTO> findAllSchedule();


    // 강사 찾기(옵션 선택용)
    List<UserDTO> findAllTeacher();
    void registNewSchedule(ScheduleDTO newSchedule);

}
