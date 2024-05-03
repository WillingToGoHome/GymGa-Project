package com.willingtogohome.gymga.emp.model.dto;

public class EmployeeDTO {

    private int code;
    private String location;
    private String year;
    private String month;
    private String totalYear;
    private String totalMonth;
    private String qual;
    private String salary;

    public EmployeeDTO() {}

    public EmployeeDTO(int code, String location, String year, String month, String totalYear, String totalMonth, String qual, String salary) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTotalYear() {
        return totalYear;
    }

    public void setTotalYear(String totalYear) {
        this.totalYear = totalYear;
    }

    public String getTotalMonth() {
        return totalMonth;
    }

    public void setTotalMonth(String totalMonth) {
        this.totalMonth = totalMonth;
    }

    public String getQual() {
        return qual;
    }

    public void setQual(String qual) {
        this.qual = qual;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
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
