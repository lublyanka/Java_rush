package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename1 = args[0];
        String filename2 = args[1];

        try(FileReader fileReader = new FileReader(filename1);
            BufferedReader reader = new BufferedReader(fileReader);
                FileWriter writer = new FileWriter(filename2)) {
                ArrayList <String> words = new ArrayList<>();
                String row;
                while (reader.ready()) {
                    row=reader.readLine();
                    words.addAll(Arrays.asList(row.split("\\s|\\n"))
                            .stream()
                            .filter(x -> x.length() >6)
                            .collect(Collectors.toList()));
                }
                writer.write(String.join(",",words));

                //JR
            /*StringBuffer sbLine = new StringBuffer();
            for (String line : fileContent) {
                String[] splitedLine = line.split(" ");
                for (String word : splitedLine) {
                    if (word.length() > 6)

                        sbLine.append(word).append(" ");
                }
            }

            String resultLine = sbLine.toString().trim().replaceAll(" ", ",");
            try (FileWriter fileWriter = new FileWriter(fileName2)) {
                fileWriter.write(resultLine);
            } catch (IOException ignore) {
                *//* NOP *//*
            }*/
        }

    }
}
