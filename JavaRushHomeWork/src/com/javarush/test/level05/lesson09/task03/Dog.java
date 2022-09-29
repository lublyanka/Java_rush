package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String dogName = null;
    public Dog(String name)
    {
        this.dogName = name;
    }

    public Dog(String name, int hight)
    {
        this.dogName = name + hight;
    }

    public Dog(String name, int age, String color)
    {
        this.dogName = name+age+color;
    }


}
