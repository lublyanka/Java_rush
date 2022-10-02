package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename1, filename2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            filename1 = reader.readLine();
            filename2 = reader.readLine();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename1));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filename2))) {
            String row;
            while (reader.ready()) {
                row = reader.readLine();
                // (?<![A-zА-я])[0-9]+(?![A-zА-я])
               /*writer.write(String.join(
                        " ",
                        Arrays.stream(row.split(" ")).filter(x -> x.matches("(?<![A-zА-я])[0-9]+(?![A-zА-я])"))
                                .collect(Collectors.toList())));*/
                StringBuilder stringBuilder = new StringBuilder();
                Arrays.stream(row.split(" ")).forEach(
                        x ->
                        {
                            if (x.matches("(?<![A-zА-я])[0-9]+(?![A-zА-я])")) {
                                stringBuilder.append(x+" ");
                            }
                        });
                writer.write(String.valueOf(stringBuilder).trim());
            }
        }
    }
}
