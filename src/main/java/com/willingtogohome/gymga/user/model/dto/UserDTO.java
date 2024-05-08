package com.willingtogohome.gymga.user.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private Integer userCode;
    private String userId;
    private String userPwd;
    private String userName;
    private String userPhone;
    private String userRole;
    private String userPic;
    private String userGender;
    private Date userBirth;
    private String userAddress;
    private String userEtc;
    private Integer userStaff;

}
