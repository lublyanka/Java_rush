package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(12.2,"Куку");
        labels.put(5.0, "орех");
        labels.put(456.0, "Жабка");
        labels.put(456456546.0, "Пирожок");
        labels.put(-2.0, "Чучух");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
