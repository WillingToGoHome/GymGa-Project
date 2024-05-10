package com.willingtogohome.gymga.user.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PhysicalDTO {

    private int userCode;
    private String height;
    private String weight;
    private String bmi;

}
