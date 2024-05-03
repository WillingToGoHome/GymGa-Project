package com.willingtogohome.gymga.fac.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@ToString
public class FacAndUserDTO {
    private int facCode;
    private String facStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd", timezone = "Asia/Seoul")
    private Date facStart;
    private UserDTO userDTO;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd", timezone = "Asia/Seoul")
    private Date facEnd;
    public FacAndUserDTO() {}

    public FacAndUserDTO(int facCode, String facStatus, Date facStart, UserDTO user, Date facEnd) {
        this.facCode = facCode;
        this.facStatus = facStatus;
        this.facStart = facStart;
        this.userDTO = user;
        this.facEnd = facEnd;
    }
}
