package com.willingtogohome.gymga.sale.model.dto;


import lombok.*;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Setter
@Getter
public class ValidateDTO {

    private String valStatus;
    private Integer passCode;
    private Integer userCode;
}
