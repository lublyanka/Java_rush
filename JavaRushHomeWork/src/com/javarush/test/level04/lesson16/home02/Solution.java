package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nam1 = Integer.parseInt(reader.readLine());
        int nam2 = Integer.parseInt(reader.readLine());
        int nam3 = Integer.parseInt(reader.readLine());
        if (nam1 > nam2)
        {
            if (nam2 > nam3)
                System.out.print(nam2);
            else
            {
                if (nam1 > nam3)
                    System.out.print(nam3);
                else
                    System.out.print(nam1);
            }
        }
        else
        {
            if (nam1 > nam3)
                System.out.print(nam1);
            else
            {
                if (nam2 > nam3)
                    System.out.print(nam3);
                else
                    System.out.print(nam2);
            }


        }
    }
}
