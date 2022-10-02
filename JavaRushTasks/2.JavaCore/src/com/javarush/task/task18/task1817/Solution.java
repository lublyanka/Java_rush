package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        if(args.length < 1)
            throw new IllegalArgumentException();
        try (FileInputStream inputStream = new FileInputStream(args[0])){
            int size = inputStream.available();
            int space = ' ';
            int countSpaces=0;
         while (inputStream.available()>0){
             if (inputStream.read()==space)
                 countSpaces++;
         }
            //System.out.println(size);
         //System.out.println(countSpaces);
         System.out.println(String.format("%.2f",countSpaces*1.0/size*100));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
