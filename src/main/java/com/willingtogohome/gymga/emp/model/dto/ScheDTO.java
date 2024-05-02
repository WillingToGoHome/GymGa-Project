package com.willingtogohome.gymga.emp.model.dto;

import java.sql.Date;
import java.sql.Time;

public class ScheDTO {

    private int code;
    private String classCode;
    private Date date;
    private Time start;
    private int emp;
    private ClassDTO classDTO;
    private EmpDTO empDTO;

    public ScheDTO() {}

    public ScheDTO(int code, String classCode, Date date, Time start, int emp, ClassDTO classDTO, EmpDTO empDTO) {
        this.code = code;
        this.classCode = classCode;
        this.date = date;
        this.start = start;
        this.emp = emp;
        this.classDTO = classDTO;
        this.empDTO = empDTO;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public int getEmp() {
        return emp;
    }

    public void setEmp(int emp) {
        this.emp = emp;
    }

    public ClassDTO getClassDTO() {
        return classDTO;
    }

    public void setClassDTO(ClassDTO classDTO) {
        this.classDTO = classDTO;
    }

    public EmpDTO getEmpDTO() {
        return empDTO;
    }

    public void setEmpDTO(EmpDTO empDTO) {
        this.empDTO = empDTO;
    }

    @Override
    public String toString() {
        return "ScheDTO{" +
                "code=" + code +
                ", classCode='" + classCode + '\'' +
                ", date=" + date +
                ", start=" + start +
                ", emp=" + emp +
                ", classDTO=" + classDTO +
                ", empDTO=" + empDTO +
                '}';
    }
}
