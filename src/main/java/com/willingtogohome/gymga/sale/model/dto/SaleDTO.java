package com.willingtogohome.gymga.sale.model.dto;

import lombok.*;

import java.sql.Date;
import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class SaleDTO {

    private Integer userCode;
    private String salesMethod;
    private Time salesDate;


}
