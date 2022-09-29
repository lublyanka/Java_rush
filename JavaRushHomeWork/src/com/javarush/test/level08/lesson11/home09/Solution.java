package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
*/

public class Solution
{
    public static void main(String[] args)
    {
       /* String date = "MAY 1 2013";
        System.out.print(isDateOdd(date));  */
    }

    public static boolean isDateOdd(String date)
    {
        Date dateDate = new Date(date);
        int dayOfYear = dateDate.getDay();
        if(dayOfYear%2 ==0)
            return true;
        return false;
    }
}
