package com.willingtogohome.gymga.login.common;

public enum UserRole {

    ADMIN("대표"),
    USER("직원");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "role='" + role + '\'' +
                '}';
    }
}
