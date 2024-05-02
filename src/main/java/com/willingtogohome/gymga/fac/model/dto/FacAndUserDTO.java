package com.willingtogohome.gymga.fac.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class FacAndUserDTO {
    private int facCode;
    private String facStatus;
    private Date facStart;
    private UserDTO user;
    private Date facEnd;
    public FacAndUserDTO() {}

    public FacAndUserDTO(int facCode, String facStatus, Date facStart, UserDTO user, Date facEnd) {
        this.facCode = facCode;
        this.facStatus = facStatus;
        this.facStart = facStart;
        this.user = user;
        this.facEnd = facEnd;
    }
}
