package com.willingtogohome.gymga.user.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PhysicalDTO {

    private int code;
    private String height;
    private String weight;
    private String bmi;

}
