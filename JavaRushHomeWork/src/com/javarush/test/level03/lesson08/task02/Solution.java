package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры Имя и два числа, вывести надпись:
name1 получает «число1» денег через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String theFirstOfString = " получает ", theMiddleOfString = " через ", theEndOfString = " лет.";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String sMoney = reader.readLine();
        String sAge = reader.readLine();
        int nMoney = Integer.parseInt(sMoney);
        int nAge = Integer.parseInt(sAge);
        System.out.print(name1 + theFirstOfString + nMoney + theMiddleOfString + nAge + theEndOfString);
    }
}