package com.willingtogohome.gymga.pass.model.dto;


import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PassAndPassQualDTO {

    private Integer passCode;
    private String passStatus;
    private Date passStart;
    private Date passEnd;
    private Integer passTotal;
    private Integer passUse;
    private Integer userCode;
    private String pqCode;

    private PassQualDTO passQualDTO;
}
