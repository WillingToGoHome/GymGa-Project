package com.willingtogohome.gymga.login.user.model.dto;

public class RegistDTO {

    private int userCode;
    private String userId;
    private String userPwd;
    private String userName;
    private String userPhone;
    private String userBirth;
    private String userAddress;
    private String userEtc;
    private String role;
    private String userPic;
    private String userGender;

    public RegistDTO(){}

    public RegistDTO(int userCode, String userId, String userPwd, String userName, String userPhone, String userBirth, String userAddress, String userEtc, String role, String userPic, String userGender) {
        this.userCode = userCode;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userBirth = userBirth;
        this.userAddress = userAddress;
        this.userEtc = userEtc;
        this.role = role;
        this.userPic = userPic;
        this.userGender = userGender;
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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    @Override
    public String toString() {
        return "RegistDTO{" +
                "userCode=" + userCode +
                ", userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userEtc='" + userEtc + '\'' +
                ", role='" + role + '\'' +
                ", userPic='" + userPic + '\'' +
                ", userGender='" + userGender + '\'' +
                '}';
    }
}
