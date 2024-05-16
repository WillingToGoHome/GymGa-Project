package com.willingtogohome.gymga.fac.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FacAndUserDTO {
    private int facCode;
    private String facStatus;
    private Date facStart;
    private UserDTO userDTO;
    private Date facEnd;
}
