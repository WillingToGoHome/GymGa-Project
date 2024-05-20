package com.willingtogohome.gymga.fac.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.Comparator;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FacDTO {

    private int facCode;
    private String facStatus;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date facStart;
    private Integer userCode;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date facEnd;

}
