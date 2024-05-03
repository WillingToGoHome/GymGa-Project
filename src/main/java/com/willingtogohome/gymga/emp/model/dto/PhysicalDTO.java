package com.willingtogohome.gymga.emp.model.dto;

public class PhysicalDTO {

    private int code;
    private String height;
    private String weight;
    private String bmi;

    public PhysicalDTO() {}

    public PhysicalDTO(int code, String height, String weight, String bmi) {
        this.code = code;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    @Override
    public String toString() {
        return "PhysicalDTO{" +
                "code=" + code +
                ", height=" + height +
                ", weight=" + weight +
                ", bmi=" + bmi +
                '}';
    }
}
