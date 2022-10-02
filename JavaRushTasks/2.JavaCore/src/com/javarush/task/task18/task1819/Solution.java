package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        try (FileInputStream inputStream1 = new FileInputStream(filename1);
             FileInputStream inputStream2 = new FileInputStream(filename2))
        {
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            while (inputStream2.available() > 0) {
                        byte[] buffer = new byte[inputStream2.available()];
                        int bytesRead = inputStream2.read(buffer);
                        arrayOutputStream.write(buffer, 0, bytesRead);
                    }

                    while (inputStream1.available()>0){
                        byte[] buffer = new byte[inputStream1.available()];
                        int bytesRead = inputStream1.read(buffer);
                        arrayOutputStream.write(buffer, 0, bytesRead);
                    }
            FileOutputStream outputStream = new FileOutputStream(filename1);
                    arrayOutputStream.writeTo(outputStream);
                    outputStream.close();
                    arrayOutputStream.close();

        }
    }
}
