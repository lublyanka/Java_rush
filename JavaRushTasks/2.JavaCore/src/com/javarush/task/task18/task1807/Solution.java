package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            int commaCounter=0;
            reader.close();

            int nextByte;

            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                while (fileInputStream.available() > 0) {
                    nextByte = fileInputStream.read();
                    //Character.toChars(nextByte);
                    if (nextByte == 44) {
                        commaCounter++;
                    }
                }

            }

            System.out.println(commaCounter);

        } catch (IOException e) {
            System.out.println("Имя файла не считано");
            throw new RuntimeException(e);
        }
    }
}
