package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        String filename1 = args[0];
        String filename2 = args[1];

        try (FileReader fileReader = new FileReader(filename1);
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter writer = new FileWriter(filename2)) {
            ArrayList<String> words = new ArrayList<>();
            String row;
            while (reader.ready()) {
                row = reader.readLine();
                words.addAll(Arrays.asList(row.split(" "))
                        .stream()
                        .filter(x -> x.matches(".*\\d.*"))
                        .collect(Collectors.toList()));
            }
            writer.write(String.join(" ", words));

            // JR
            /*String fileReadLine;
            String[] splitedLine;
            while ((fileReadLine = fileReader.readLine()) != null) {
                splitedLine = fileReadLine.split(" ");
                for (String word : splitedLine) {
                    if (word.matches(".*[0-9].*")) {
                        fileWriter.write(word + " ");
                    }
                }
            }*/

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
