package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        TreeMap<String,Double> accounts = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()){
                String[] person = reader.readLine().split(" ");
                String personName = person[0];
                Double personMoney = Double.valueOf(person[1]);
                if(accounts.get(personName) == null)
                    accounts.merge(personName, personMoney, Double::sum);
                else if(accounts.get(personName) < personMoney)
                    accounts.merge(personName, personMoney, Double::sum);}
        }

        accounts.forEach((x,y) -> {System.out.println(x + " " + y);});

    }
}
