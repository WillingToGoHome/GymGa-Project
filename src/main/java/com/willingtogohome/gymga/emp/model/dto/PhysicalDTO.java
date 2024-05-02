package com.willingtogohome.gymga.emp.model.dto;

public class PhysicalDTO {

    private int code;
    private double height;
    private double weight;
    private double bmi;

    public PhysicalDTO() {}

    public PhysicalDTO(int code, double height, double weight, double bmi) {
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
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
