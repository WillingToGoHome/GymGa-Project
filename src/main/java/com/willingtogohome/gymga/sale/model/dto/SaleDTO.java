package com.willingtogohome.gymga.sale.model.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class SaleDTO {

    private Integer passCode;
    private String salesMethod;
    private Date salesDate;


}
