package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename1, filename2;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            filename1 = bufferedReader.readLine();
            filename2 = bufferedReader.readLine();
        }

        /*try (BufferedReader reader2 = new BufferedReader(new FileReader(filename1));
             FileWriter writer = new FileWriter(filename2)) {
            while (reader2.ready()) {
                String row = reader2.readLine();
                for (int i = 1; i < row.length(); i+2) {
                        writer.write(row.charAt(i));
                }
            }
        }*/

        ArrayList<Integer> list = new ArrayList<Integer>();
        try (FileReader fileReader = new FileReader(filename1)) {
            while (fileReader.ready()) {
                list.add(fileReader.read());
            }
        }

        try (FileWriter fileWriter = new FileWriter(filename2)) {
            for (int i = 1; i < list.size(); i = i + 2) {
                fileWriter.write((byte) (int) list.get(i));
            }
        }
    }
}
