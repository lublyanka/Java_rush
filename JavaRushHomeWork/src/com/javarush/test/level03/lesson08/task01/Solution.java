package com.javarush.test.level03.lesson08.task01;

/* Как захватить мир
Ввести с клавиатуры число и имя, вывести на экран строку:
«имя» захватит мир через «число» лет. Му-ха-ха!
Пример: Вася захватит мир через 8 лет. Му-ха-ха!
*/

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String theFirstOfString = " захватит мир через ", theEndOfString = " лет. Му-ха-ха!";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sAge = reader.readLine();
        String name1 = reader.readLine();
        int nAge = Integer.parseInt(sAge);
        System.out.print(name1 + theFirstOfString +  sAge + theEndOfString);
    }
}