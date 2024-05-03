package com.willingtogohome.gymga.fac.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
@Setter
@ToString
public class UserDTO {
    private int userCode;

    public UserDTO() {}

    public UserDTO(int userCode) {
        this.userCode = userCode;
    }
}
