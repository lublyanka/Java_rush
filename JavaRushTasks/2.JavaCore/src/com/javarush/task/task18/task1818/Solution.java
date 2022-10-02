package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();
        reader.close();

        try(FileInputStream inputStream2 = new FileInputStream(filename2);
        FileInputStream inputStream3 = new FileInputStream(filename3);
        FileOutputStream outputStream1 = new FileOutputStream(filename1)){
            while(inputStream2.available() > 0){
                byte[] buff = new byte[500];
                int count = inputStream2.read(buff);
                outputStream1.write(buff,0,count);
            }

            while(inputStream3.available() > 0){
                byte[] buff = new byte[500];
                int count = inputStream3.read(buff);
                outputStream1.write(buff,0,count);
            }
        }

    }
}
