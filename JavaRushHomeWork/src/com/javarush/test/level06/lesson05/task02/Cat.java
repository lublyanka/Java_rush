package com.javarush.test.level06.lesson05.task02;

/* Классы Cat и Dog и метод finalize для каждого
В каждом классе Cat и Dog написать метод finalize, который выводит на экран текст о том, что такой-то объект уничтожен.
*/

public class Cat
{
    String name;

   // public Cat(String name)
   // {
    //    this.name = name;
   // }

    protected void finalize() throws Throwable
    {
        System.out.print(name + " destroyed");
    }

    //public static void main(String[] args)
    //{
    //    Cat cat = new Cat("test")  ;
    //}

}

class Dog
{
    String name;

    //Dog(String name)
    //{
    //    this.name = name;
   // }

    protected void finalize() throws Throwable
    {
        System.out.print(name + " destroyed");
    }


}



