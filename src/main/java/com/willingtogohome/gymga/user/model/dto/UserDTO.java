package com.willingtogohome.gymga.user.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

    private int code;
    private String id;
    private String pwd;
    private String name;
    private String phone;
    private String role;
    private String pic;
    private String gender;
    private String birth;
    private String address;
    private String etc;
    private String staff;
}
