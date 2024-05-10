package com.willingtogohome.gymga.schedule.model.dto;


import com.willingtogohome.gymga.pass.model.dto.PassDTO;
import com.willingtogohome.gymga.user.model.dto.EmpDTO;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import lombok.*;

import java.sql.Date;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleAndClassAndUserAndPassDTO {
    private int scheCode;
    private ClassDTO classCategory;
    private Date scheRegDate;
    private Date scheRunDate;
    private LocalTime scheStartTime;
    private LocalTime scheEndTime;
    private int scheParticipate;
    private String scheAtten;
    private EmpDTO empCategory;
    private UserDTO userCategory;
    private PassDTO passCategory;


}
