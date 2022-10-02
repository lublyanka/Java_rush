package com.javarush.task.task21.task2113;
/*Теперь вернемся к методу print класса Horse.
        ..........Homer
        Другими словами, в методе print надо вывести на экран строку состоящую из точек и имени лошади.
        Количество точек равно distance, округленному (в меньшую сторону) до целого числа.
        Requirements:
        1. Метод print должен выводить на экран строку состоящую из точек и имени лошади. Количество точек равно целой части distance.*/
public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move(){
        distance += speed*Math.random();
    };

    public void print() {
        double distance = Math.floor(this.distance) ;
        for (int i = 0; i < distance; i++) {
            System.out.print(".");
        }
        System.out.println(this.name);
    };
}
