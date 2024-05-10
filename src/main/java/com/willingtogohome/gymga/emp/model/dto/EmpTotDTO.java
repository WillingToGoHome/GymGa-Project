package com.willingtogohome.gymga.emp.model.dto;

import java.sql.Date;

public class EmpTotDTO {

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
    private PhysicalDTO physicalDTO;
    private EmployeeDTO employeeDTO;

    public EmpTotDTO() {}

    public EmpTotDTO(int code, String id, String pwd, String name, String phone, String role, String pic, String gender, Date birth, String address, String etc, PhysicalDTO physicalDTO, EmployeeDTO employeeDTO) {
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
        this.physicalDTO = physicalDTO;
        this.employeeDTO = employeeDTO;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
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

    public PhysicalDTO getPhysicalDTO() {
        return physicalDTO;
    }

    public void setPhysicalDTO(PhysicalDTO physicalDTO) {
        this.physicalDTO = physicalDTO;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    @Override
    public String toString() {
        return "EmpTotDTO{" +
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
                ", physicalDTO=" + physicalDTO +
                ", employeeDTO=" + employeeDTO +
                '}';
    }
}
