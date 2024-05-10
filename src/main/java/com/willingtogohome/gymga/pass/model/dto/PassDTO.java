package com.willingtogohome.gymga.pass.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PassDTO {

    private Integer passCode;
    private String pqCode;
    private String passStatus;
    private Date passStart;
    private Date passEnd;
    private Integer passTotal;
    private Integer passUse;
    private Integer userCode;
}
