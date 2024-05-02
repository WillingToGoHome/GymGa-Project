package com.willingtogohome.gymga.login.user.model.dto;

public class RegistDTO {
    private String userId;
    private String userPwd;
    private String userName;
    private String userPhone;
    private String userBirth;
    private String userAddress;
    private String userEtc;
    private String userRole;

    public RegistDTO(){}

    public RegistDTO(String userId, String userPwd, String userName, String userPhone, String userBirth, String userAddress, String userEtc, String userRole) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userBirth = userBirth;
        this.userAddress = userAddress;
        this.userEtc = userEtc;
        this.userRole = userRole;
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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEtc() {
        return userEtc;
    }

    public void setUserEtc(String userEtc) {
        this.userEtc = userEtc;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "RegistDTO{" +
                "userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userEtc='" + userEtc + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }

}
