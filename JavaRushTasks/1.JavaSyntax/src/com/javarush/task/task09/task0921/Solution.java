package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    private static ArrayList<Double> numbers =new ArrayList<>();

    public static void main(String[] args) {
        readData();
        /*for (Double number : numbers) {
            System.out.println(number);
        }
        numbers.forEach(number -> { System.out.println(number);});*/
    }

    public static void readData() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                       numbers.add(Double.parseDouble(reader.readLine()));
                       System.out.println();
            }
        }
        catch (Exception e)
        {
            //System.out.println(e);
        }
        finally {
            for (Double number : numbers) {
                System.out.println(number);
            }
            //numbers.forEach(number -> { System.out.println(number);});

        }
    }
}
