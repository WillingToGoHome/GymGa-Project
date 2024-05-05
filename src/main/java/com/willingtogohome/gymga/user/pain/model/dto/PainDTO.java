package com.willingtogohome.gymga.user.pain.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PainDTO {

    private int pos;
    private String type;
    private String dur;
    private String cause;
    private int str;
    private String etc;
    private int pain_code;
}
