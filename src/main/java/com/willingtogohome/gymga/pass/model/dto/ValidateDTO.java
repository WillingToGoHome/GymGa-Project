package com.willingtogohome.gymga.pass.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ValidateDTO {

    private String valStatus;
    private int passCode;
    private int memberCode;
}
