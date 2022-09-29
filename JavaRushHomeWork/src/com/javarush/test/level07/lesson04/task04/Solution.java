package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrayFirst = new int[10];
        int[] arraySecond = new int[10];
        for(int i = 0; i < 10 ; i++)
        {
            arrayFirst[i] = Integer.parseInt(reader.readLine());
        }
        int testWay = 9;
        for(int j = 0; j< 10; j++)
        {
            arraySecond[j]=arrayFirst[testWay];
            testWay--;
        }

        arrayFirst = arraySecond.clone();

        for(int i = 0; i < 10; i++)
        {
            System.out.println(arrayFirst[i]);
        }
    }
}
