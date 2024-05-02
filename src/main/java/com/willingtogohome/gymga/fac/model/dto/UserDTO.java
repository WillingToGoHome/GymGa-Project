package com.willingtogohome.gymga.fac.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    public UserDTO() {}

    public UserDTO(int userCode, String userId, String userPwd, String userName, String userPhone, String userRole, String userPic, String userGender, Date userBirth, String userAddress, String userEtc, int userStaff) {
        this.userCode = userCode;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userRole = userRole;
        this.userPic = userPic;
        this.userGender = userGender;
        this.userBirth = userBirth;
        this.userAddress = userAddress;
        this.userEtc = userEtc;
        this.userStaff = userStaff;
    }
}
