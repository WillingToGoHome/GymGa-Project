package com.willingtogohome.gymga.schedule.model.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleAndClassAndUserAndPassDTO {

    private int scheCode;
    private ClassDTO classCategory;
    private LocalDateTime scheRegDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scheRunDate;
    private LocalTime scheStartTime;
    private LocalTime scheEndTime;
    private int registrationCount;
    private int scheParticipate;
    private String scheAtten;
    private EmpDTO empCategory;
    private MemberDTO userCategory;
    private PassqualDTO passqualCategory;
    private PassTotalDTO passTotalCategory;
    private PassUseDTO passUseCategory;

}
