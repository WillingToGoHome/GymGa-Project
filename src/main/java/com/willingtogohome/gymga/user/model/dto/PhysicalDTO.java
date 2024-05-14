package com.willingtogohome.gymga.user.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhysicalDTO {

    private int userCode;
    private String height;
    private String weight;
    private String bmi;

}
