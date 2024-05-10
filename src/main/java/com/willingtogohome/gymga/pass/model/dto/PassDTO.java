package com.willingtogohome.gymga.pass.model.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PassDTO {

    private int passCode;
    private String pqCode;
    private String passStatus;
    private Date passStart;
    private Date passEnd;
    private int passTotal;
    private int passUse;
    private int userCode;

}
