package com.javarush.test.level04.lesson10.task05;

/* Таблица умножения
Вывести на экрацн таблицу умножения 10х10 используя икл while. Числа разделить пробелом.
1 2 3 4 5 6 7 8 9 10
2 4 6 8 10 12 14 16 18 20
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int x = 1;
        while( x < 11)
        {
            int y = 1;
            while(y < 11)
            {
                System.out.print(y*x + " ");
                y++;
            }
            x++;
            System.out.println();
        }

    }
}
