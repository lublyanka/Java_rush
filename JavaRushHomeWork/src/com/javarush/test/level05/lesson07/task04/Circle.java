package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    private String circleWay = null;
    public void initialize(int centerX, int centerY, int radius)
    {
        this.circleWay = String.valueOf(centerX + centerY + radius);
    }

    public void initialize(int centerX, int centerY, int radius, int width)
    {
        this.circleWay = String.valueOf(centerX + centerY + radius + width);
    }

    public void initialize(int centerX, int centerY, int radius, int width, String color)
    {
        this.circleWay = centerX + centerY + radius + width + color;
    }

}
