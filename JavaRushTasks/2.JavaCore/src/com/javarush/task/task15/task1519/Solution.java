package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        ArrayList<String> rows = new ArrayList<>();
        try {
            while (!(line = reader.readLine()).equals("exit")) {
                rows.add(line);
            }
        } catch (IOException e) {
            //System.out.println(e);
        }

        reader.close();

        rows.forEach(row -> {
            try {
                if (row.contains(".")) {
                    print(Double.parseDouble(row));
                } else {
                    int shortLine = Integer.parseInt(row);
                    if (shortLine > 0 && shortLine < 128) {
                        print((short) shortLine);
                    } else  {
                        print(shortLine);
                    }
                }
            }
            catch (NumberFormatException e) {
                print(row);
            }
        });

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
