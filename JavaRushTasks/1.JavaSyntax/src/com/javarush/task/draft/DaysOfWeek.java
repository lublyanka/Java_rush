package com.javarush.task.draft;

public enum DaysOfWeek {
    MONDAY ("El lunes"),
    TUESDAY ("El martes"),
    WEDNESDAY ("El miercoles"),
    THURSDAY ("El jueves"),
    FRIDAY ("El viernes"),
    SATURDAY ("El sabado"),
    SUNDAY ("El domingo");


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    DaysOfWeek(String name) {
        this.name=name;
    }
}
