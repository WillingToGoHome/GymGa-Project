package com.willingtogohome.gymga.user.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchCriteria {

    private String condition;
    private String text;
}
