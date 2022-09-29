package com.javarush.test.level06.lesson08.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
void readLn() – ждет нажатия enter [использовать readString()]
*/

public class ConsoleReader
{
    public static void main(String[] args)   throws Exception
    {
         readLn();
    }


    public static String readString() throws Exception
    {
        String result = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return result = reader.readLine();
    }

    public static int readInt() throws Exception
    {
        int result = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return result = Integer.parseInt(reader.readLine());

    }

    public static double readDouble() throws Exception
    {
        double result = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return result = Double.parseDouble(reader.readLine());
    }

    public static void readLn() throws Exception
    {
        while (readString().equals("/n"))
        {
        readString();
        }

    }
}
