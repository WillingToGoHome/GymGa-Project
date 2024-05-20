package com.willingtogohome.gymga.user.pain.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PainDTO {

    private int userCode;
    private int pos;
    private String type;
    private String dur;
    private String cause;
    private int str;
    private String etc;
    private String userName;
}
