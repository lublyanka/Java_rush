package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName="";
        int minByte=256; //int minByte = Byte.MAX_VALUE;
        int currentByte =0;

        try {
            fileName = reader.readLine();
        }
        catch (IOException e){}


        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0)
            {
                currentByte=fileInputStream.read();
                if(currentByte < minByte)
                {minByte=currentByte;}
            }

        }
        System.out.println(minByte);
        reader.close();
    }
}
