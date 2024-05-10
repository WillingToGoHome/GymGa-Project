package com.willingtogohome.gymga.schedule.model.dto;


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
    private MemberDTO userCategory;
    private PassTotalDTO passTotalCategory;
    private PassUseDTO passUseCategory;


}
