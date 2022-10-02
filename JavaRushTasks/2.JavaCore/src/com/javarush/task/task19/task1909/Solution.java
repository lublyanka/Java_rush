package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileIn,
               fileOut;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileIn = reader.readLine();
            fileOut = reader.readLine();
        }


        try(BufferedWriter  outputStream = new BufferedWriter ( new FileWriter(fileOut));
        BufferedReader fileReader = new BufferedReader( new FileReader(fileIn))){
            int  row;
            while (fileReader.ready())
            {
                row = fileReader.read();
                if (row==(int) '.')
                    outputStream.write('!');
                else
                    outputStream.write(row);
            }
        }

    }
}
