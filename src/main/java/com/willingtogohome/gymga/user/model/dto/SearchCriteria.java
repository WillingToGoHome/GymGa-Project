package com.willingtogohome.gymga.user.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchCriteria {

    private String condition;
    private String text;
}
