package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Arrays;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String filename1, filename2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        filename1 = reader.readLine();
        filename2 = reader.readLine();
        MeRound(filename1,filename2);
    }

    public static void MeRound(String fileName1, String fileName2) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(fileName1);
             FileOutputStream outputStream = new FileOutputStream(fileName2);
             BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream))) {

            while (inputStream.available() > 0) {
                String row = fileReader.readLine();
                String[] rows = row.split(" ");
                rows = Arrays.stream(rows).map((x) -> String.valueOf(Math.round(Double.valueOf(x)))).toArray(String[]::new);
                String resultString = String.join(" ", rows);
                outputStream.write(resultString.getBytes());
            }
    }}

    public static void JRushRound(String fileName1, String fileName2) throws IOException {
        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName1));
             PrintWriter printWriter = new PrintWriter(new FileWriter(fileName2))) {

            while (bufferedFileReader.ready()) {
                String[] splittedLine = bufferedFileReader.readLine().split(" ");
                for (String numberInString : splittedLine) {
                    double number = Double.parseDouble(numberInString);
                    long roundedNumber = Math.round(number);
                    printWriter.print(roundedNumber + " ");
                }
            }
        }
    }
}