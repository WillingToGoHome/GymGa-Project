package com.willingtogohome.gymga.login.auth.model.dto;

import java.sql.Date;

public class MemberAndPassDTO {

    private int userCode;
    private String userName;
    private String userGender;
    private String userPhone;
    private String pqName;
    private Date passEnd;

    public MemberAndPassDTO() {}

    public MemberAndPassDTO(int userCode, String userName, String userGender, String userPhone, String pqName, Date passEnd) {
        this.userCode = userCode;
        this.userName = userName;
        this.userGender = userGender;
        this.userPhone = userPhone;
        this.pqName = pqName;
        this.passEnd = passEnd;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPqName() {
        return pqName;
    }

    public void setPqName(String pqName) {
        this.pqName = pqName;
    }

    public Date getPassEnd() {
        return passEnd;
    }

    public void setPassEnd(Date passEnd) {
        this.passEnd = passEnd;
    }

    @Override
    public String toString() {
        return "MemberAndPassDTO{" +
                "userCode=" + userCode +
                ", userName='" + userName + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", pqName='" + pqName + '\'' +
                ", passEnd=" + passEnd +
                '}';
    }
}
