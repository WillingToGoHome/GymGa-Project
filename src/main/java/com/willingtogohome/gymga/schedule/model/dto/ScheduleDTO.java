package com.willingtogohome.gymga.schedule.model.dto;


import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleDTO {

    private int scheCode;
    private String classCode;
    private Date scheRegDate;
    private Date scheRunDate;
    private Time scheStartTime;
    private Time scheEndTime;
    private int scheParticipate;
    private String scheAtten;
    private int empCode;
    private int memberCode;
    private int passCode;

}
