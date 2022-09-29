package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{

    public static void swap(int[] arr, int i, int j)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void bubblesort(int[] arr)
    {
        for(int i = arr.length-1 ; i > 0 ; i--)
        {
            for(int j = 0 ; j < i ; j++)
            {
                if( arr[j] > arr[j+1] )
                    swap(arr, j, j+1);
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[3];
        array[0] = Integer.parseInt(reader.readLine());
        array[1] = Integer.parseInt(reader.readLine());
        array[2] = Integer.parseInt(reader.readLine());
        bubblesort(array);
        System.out.print(array[2] + " " + array[1] + " " +  array[0]);



    }


}


