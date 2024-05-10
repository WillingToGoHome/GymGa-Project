package com.willingtogohome.gymga.user.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SearchCriteria {

    private String condition;
    private String text;
}
