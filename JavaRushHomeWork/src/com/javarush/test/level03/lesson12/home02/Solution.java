package com.javarush.test.level03.lesson12.home02;

/* Я не хочу изучать Java, я хочу большую зарплат
Вывести на экран десять раз надпись «Я не хочу изучать Java, я хочу большую зарплату»
*/

public class Solution
{
    public static void main(String[] args)
    {
        String line = "Я не хочу изучать Java, я хочу большую зарплату";
        for(int i = 0; i < 10; i++)
        {
            System.out.println(line);
        }
    }
}
