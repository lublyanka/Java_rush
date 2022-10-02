package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            filename = reader.readLine();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String id = args[0];
            while(reader.ready()){
                String row = reader.readLine();
                if (row.startsWith(id + " ")){
                    System.out.println(row);
                    break;
                }
            }
        }
    }
}
