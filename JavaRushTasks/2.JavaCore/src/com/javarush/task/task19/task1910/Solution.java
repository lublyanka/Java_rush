package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename1, filename2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            filename1 = reader.readLine();
            filename2 = reader.readLine();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename1));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filename2))){
            String row;
            while (reader.ready()){
                row=reader.readLine().replaceAll("\\p{Punct}*\\n*", "");
                writer.write(row);
            }
        }
    }
}
