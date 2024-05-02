package com.willingtogohome.gymga.schedule.model.dao;

import com.willingtogohome.gymga.schedule.model.dto.ScheduleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    List<ScheduleDTO> findAllSchedule();
}
