package com.willingtogohome.gymga.pass.model.dto;

import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {

    private int memberCode;
    private String salesMethod;
    private Time salesDate;
    private int passNo;
}
