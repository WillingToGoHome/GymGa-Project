package com.willingtogohome.gymga.emp.model.dto;

import java.sql.Date;

public class EmpDTO {

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

    public EmpDTO() {}

    public EmpDTO(int code, String id, String pwd, String name, String phone, String role, String pic, String gender, String birth, String address, String etc) {
        this.code = code;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.phone = phone;
        this.role = role;
        this.pic = pic;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
        this.etc = etc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    @Override
    public String toString() {
        return "EmpDTO{" +
                "code=" + code +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", pic='" + pic + '\'' +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                ", etc='" + etc + '\'' +
                '}';
    }
}
