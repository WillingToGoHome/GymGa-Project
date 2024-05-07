package com.willingtogohome.gymga.schedule.model.dto;


import lombok.*;

import java.time.LocalTime;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleDTO {

    private int scheCode;           // 일정코드
    private String classCode;       // 강의코드 (1:1 PT, 필라테스, 스피닝, 에어로빅)
    private Date scheRegDate;       // 등록일자
    private Date scheRunDate;       // 시작일
    private LocalTime scheStartTime;     // 시작시간
    private LocalTime scheEndTime;       // 종료시간
    private int scheParticipate;    // 참여인원
    private String scheAtten;       // 참석여부??
    private int empCode;            // 직원코드
    private int memberCode;         // 회원코드
    private int passCode;           // 이용권코드

}
