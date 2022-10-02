package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String fileNameIN = reader.readLine();
            String fileNameOUT = reader.readLine();

            FileInputStream inputStream = new FileInputStream(fileNameIN);
            FileOutputStream outputStream = new FileOutputStream(fileNameOUT);

            List<Integer> fileIn= new ArrayList<>();

            while (inputStream.available() > 0){
                fileIn.add(inputStream.read());
            }

            for (int i = fileIn.size(); i > 0 ; i--) {
                outputStream.write(fileIn.get(i-1));
            }

            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
