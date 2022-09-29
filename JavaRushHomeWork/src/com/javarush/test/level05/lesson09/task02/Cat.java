package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    String name;
    String address;
    String color;
    int weight;
    int old;

    public Cat(String name)
    {
        this.name = name;

    }

    public Cat(String name, int weight, int old)
    {
        this.name = name;
        this.weight = weight;
        this.old = old;
    }

    public Cat(String name, int old)
    {
        this.name = name;
        this.old = old;
        weight = 2;
    }

    public Cat(int weight, String color)
    {
        this.weight = weight;
        this.color = color;
        name = null;
        address = null;
        old = 1;
    }

    public Cat(int weight, String color, String address)
    {
        this.weight = weight;
        this.color = color;
        this.address = address;
        name = null;
        old = 1;
    }

    public static void main(String[] args)   throws Exception
    {

    }

}
