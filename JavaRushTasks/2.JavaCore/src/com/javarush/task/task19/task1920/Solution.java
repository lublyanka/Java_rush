package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
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

        Double max = accounts.entrySet().stream().max(Comparator.comparingDouble(Map.Entry::getValue)).get().getValue();
        //System.out.println(max);
        //accounts.forEach((x,y) -> System.out.println(x + " " + y));
        accounts.forEach((x,y) -> {if (y.equals(max)) System.out.println(x + " ");});

    }

    //JR
    /*public static void main(String[] args) {
        TreeMap<String, Double> salary = new TreeMap<>();

        String fileName = args[0];

        try (BufferedReader rd = new BufferedReader(new FileReader(fileName))) {
            String[] splitedLine;
            String line;
            Double currentValue;

            while ((line = rd.readLine()) != null) {
                splitedLine = line.split(" ");
                String name = splitedLine[0];
                double value = Double.parseDouble(splitedLine[1]);

                if (salary.containsKey(name)) {
                    currentValue = salary.get(name);
                    salary.put(name, value + currentValue);
                } else {
                    salary.put(name, value);
                }
            }
        } catch (IOException ignore) {
            *//*NOP *//*
        }

        double maxSalary = salary.firstEntry().getValue();
        for (double value : salary.values()) {
            if (value > maxSalary) {
                maxSalary = value;
            }
        }

        TreeSet<String> names = new TreeSet<>();
        for (String name : salary.keySet()) {
            if (maxSalary == salary.get(name)) {
                names.add(name);
            }
        }

        for (String name : names) {
            System.out.println(name);
        }
    }*/
}
