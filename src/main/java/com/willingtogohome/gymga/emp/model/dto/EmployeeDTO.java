package com.willingtogohome.gymga.emp.model.dto;

public class EmployeeDTO {

    private int code;
    private String location;
    private int year;
    private int month;
    private int totalYear;
    private int totalMonth;
    private String qual;
    private int salary;

    public EmployeeDTO() {}

    public EmployeeDTO(int code, String location, int year, int month, int totalYear, int totalMonth, String qual, int salary) {
        this.code = code;
        this.location = location;
        this.year = year;
        this.month = month;
        this.totalYear = totalYear;
        this.totalMonth = totalMonth;
        this.qual = qual;
        this.salary = salary;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getTotalYear() {
        return totalYear;
    }

    public void setTotalYear(int totalYear) {
        this.totalYear = totalYear;
    }

    public int getTotalMonth() {
        return totalMonth;
    }

    public void setTotalMonth(int totalMonth) {
        this.totalMonth = totalMonth;
    }

    public String getQual() {
        return qual;
    }

    public void setQual(String qual) {
        this.qual = qual;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "code=" + code +
                ", location='" + location + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", totalYear=" + totalYear +
                ", totalMonth=" + totalMonth +
                ", qual='" + qual + '\'' +
                ", salary=" + salary +
                '}';
    }
}
