package com.javarush.test.level03.lesson06.task04;

/* Путь к файлу java.exe
Выведи на экран текст: полное имя файла java.exe из установленного пакета java
*/

public class Solution
{
    public static void main(String[] args)
    {
        String way = System.getProperty("java.home");
        System.out.print(way + "\\bin\\java.exe");
    }
}