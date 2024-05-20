package com.willingtogohome.gymga.user.pain.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PainUpdateDTO {

    private int pos;
    private String type;
    private String dur;
    private String cause;
    private int str;
    private String etc;
    private int userCode;
}
