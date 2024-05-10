package com.willingtogohome.gymga.user.model.dto;


import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private int userCode;
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
    private int userStaff;
    private UserAndEmpDTO empCategory;

}
