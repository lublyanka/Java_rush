package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> ints = new ArrayList<>();
        ints.add(new int[]{6, 7, 8, 9, 10});
        ints.add(new int[]{0, 1});
        ints.add(new int[]{2, 3, 4, 5});
        ints.add(new int[]{21, 22, 23, 24, 25, 26, 27});
        ints.add(new int[]{});
        return ints;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
