package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> myList = new HashMap<String,Integer>();  ;
        myList.put("Пичолини",4512);
        myList.put("Жаккардов",1234);
        myList.put("Филяев",10000);
        myList.put("Кутузов",5000);
        myList.put("Жаркая",10);
        myList.put("Забивакин",2000);
        myList.put("Петров",0);
        myList.put("Шушуев",1200);
        myList.put("Балакаев",500);
        myList.put("Королев",100);
        return myList;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        ArrayList <String> surnames = new ArrayList<String> ();
        surnames.addAll(map.keySet());
        for (int i = 0; i < surnames.size(); i++) {
            if (map.get(surnames.get(i)) < 500)
                map.remove(surnames.get(i));
        }
    }

    public static void main(String[] args) {

    }
}