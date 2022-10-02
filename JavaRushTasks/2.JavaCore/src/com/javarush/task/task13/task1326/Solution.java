package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename="";
        ArrayList<Integer> numbers = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            filename = reader.readLine();}

        try (FileInputStream inputStream = new FileInputStream(filename);
            BufferedReader reader= new BufferedReader(new InputStreamReader(inputStream))) {
            reader.lines().forEach(x -> numbers.add(Integer.valueOf(x)));

            numbers.sort(Integer::compare);
            numbers.forEach(x -> {
                if ((x % 2) == 0) {
                    System.out.println(x);
                }
            });
        }
    }

}

