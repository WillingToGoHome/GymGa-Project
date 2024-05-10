package com.willingtogohome.gymga.emp.model.dto;

public class SearchCriteria {

    private String condition;
    private String text;

    public SearchCriteria() {}

    public SearchCriteria(String condition, String text) {
        this.condition = condition;
        this.text = text;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "searchCriteria{" +
                "condition='" + condition + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
