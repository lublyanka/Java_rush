package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String dogName = null;
    public void initialize(String name)
    {
        this.dogName = name;
    }

    public void initialize(String name, int hight)
    {
        this.dogName = name + hight;
    }

    public void initialize(String name, int age, String color)
    {
        this.dogName = name+age+color;
    }

}
