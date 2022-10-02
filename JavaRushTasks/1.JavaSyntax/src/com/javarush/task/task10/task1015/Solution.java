package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.List;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {

        /*ArrayList<ArrayList<String>> array = new ArrayList<>();;
        ArrayList<String> list1 = new ArrayList<>();
        list1.add(0, "qwe");
        array.add(0, list1);
        int size = array.size();

        return array.toArray(new ArrayList[size] );*/
        ArrayList<String>[] array = new ArrayList[1];
        ArrayList<String> list1 = new ArrayList<>();
        list1.add(0, "qwe");
        array[0]= list1;
        return  array;
    }


    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String string : list) {
                System.out.println(string);
            }
        }
    }
}