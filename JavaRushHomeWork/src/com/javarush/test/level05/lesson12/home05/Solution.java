package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        int sum = 0;
        while (true)
        {
            s = reader.readLine();
            if(s.equals("сумма"))
                break;
            sum = sum + Integer.parseInt(s);
        }
        System.out.print(sum);
    }
}
