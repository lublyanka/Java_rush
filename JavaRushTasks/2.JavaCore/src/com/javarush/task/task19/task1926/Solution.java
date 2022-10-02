package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))){
            String row;
            while((row = fileReader.readLine())!=null) {
                for (int i = row.length() - 1; i > -1; i--) {
                    System.out.print(row.charAt(i));
                }
                System.out.println();
            }
        }
    }
}
