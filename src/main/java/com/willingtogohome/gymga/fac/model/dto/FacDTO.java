package com.willingtogohome.gymga.fac.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Getter
@Setter
@ToString
public class FacDTO {

    private int facCode;
    private String facStatus;
    private Date facStart;
    private int userCode;
    private Date facEnd;

    public FacDTO() {}

    public FacDTO(int facCode, String facStatus, Date facStart, int userCode, Date facEnd) {
        this.facCode = facCode;
        this.facStatus = facStatus;
        this.facStart = facStart;
        this.userCode = userCode;
        this.facEnd = facEnd;
    }
}
