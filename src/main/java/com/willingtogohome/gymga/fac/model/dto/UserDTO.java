package com.willingtogohome.gymga.fac.model.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int userCode;
    private String userName;
}
