package com.willingtogohome.gymga.user.model.dto;

import lombok.*;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserTotDTO {

    private int code;
    private String id;
    private String pwd;
    private String name;
    private String phone;
    private String role;
    private String pic;
    private String gender;
    private Date birth;
    private String address;
    private String etc;
    private int staff;
    private PhysicalDTO PhysicalDTO;
}
