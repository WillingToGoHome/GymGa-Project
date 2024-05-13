package com.willingtogohome.gymga.login.user.model.dto;

import com.willingtogohome.gymga.login.common.UserRole;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginDTO {
    private int userCode;
    private String userId;
    private String userPwd;
    private String userName;
    private UserRole userRole;

    public LoginDTO(){}

    public LoginDTO(int userCode, String userId, String userPwd, String userName, UserRole userRole) {
        this.userCode = userCode;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userRole = userRole;
    }

    public List<String> getRole(){
        if (this.userRole.getRole().length() > 0) {
            System.out.println("4 UserRole" + userRole);
            return Arrays.asList(this.userRole.getRole().split(","));
        }
        return new ArrayList<>();
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "userCode=" + userCode +
                ", userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userRole=" + userRole +
                '}';
    }


}
