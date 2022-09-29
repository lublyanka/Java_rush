package com.javarush.test;

public class SortByBubble
{
    static void swap(int[] arr, int i, int j)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static void bubblesort(int[] arr)
    {
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( arr[j] > arr[j+1] )
                    swap(arr, j, j+1);
            }
        }
    }


}
