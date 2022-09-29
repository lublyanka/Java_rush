package com.javarush.test.level03.lesson06.task03;

/* Семь цветов радуги
Выведи на экран текст: семь цветов радуги.
В каждой строке должно быть по три цвета, в последней - один.
Цвета разделяй пробелом.
*/

public class Solution
{
    public static void main(String[] args)
    {
        String red = "красный", orange= "оранжевый", yellow = "желтый", green = "зеленый", cyan = "голубой", blue = "синий", purple = "фиолетовый";
        String space = " ";
        System.out.println(red + space + orange + space + yellow);
        System.out.println(green + space + cyan + space +  blue);
        System.out.println(purple);
    }
}