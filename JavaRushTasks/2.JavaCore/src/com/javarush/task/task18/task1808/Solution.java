package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    private static String filenameIn, filenameOut1, filenameOut2;

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           // while ((filenameIn==null || filenameOut1==null || filenameOut2==null)||(filenameIn.length() < 3 || filenameOut1.length() < 3 || filenameOut2.length() < 3)){
                //if(filenameIn==null ||filenameIn.length() < 3 )
                   filenameIn = reader.readLine();
               // if( filenameOut1==null ||filenameOut1.length() < 3 )
                    filenameOut1 = reader.readLine();
                //if(filenameOut2==null ||filenameOut2.length() < 3 )
                    filenameOut2 = reader.readLine();
        //}
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(filenameIn!=null && filenameOut1!=null && filenameOut2!=null) {
            try {
                FileInputStream inputStream = new FileInputStream(filenameIn);
                FileOutputStream outputStream1 = new FileOutputStream(filenameOut1);
                FileOutputStream outputStream2 = new FileOutputStream(filenameOut2);

               /* try (FileInputStream fileInputStream = new FileInputStream(filenameIn);
                     FileOutputStream fileOutputStream1 = new FileOutputStream(filenameOut1);
                     FileOutputStream fileOutputStream2 = new FileOutputStream(filenameOut2)) {

                    int halfOfFile = (fileInputStream.available() + 1) / 2;
                    int numberOfByte = 0;
                    while (fileInputStream.available() > 0) {
                        if (numberOfByte < halfOfFile) {
                            fileOutputStream1.write(fileInputStream.read());
                            numberOfByte++;
                        } else fileOutputStream2.write(fileInputStream.read());
                    }
                }*/

                while (inputStream.available() > 0) {
                    byte[] buffer  = new byte[(inputStream.available() +1) / 2];
                    inputStream.read(buffer);
                    outputStream1.write(buffer);
                    int count = inputStream.read(buffer);
                    outputStream2.write(buffer,0, count);
                }
                inputStream.close();
                outputStream1.close();
                outputStream2.close();
                }
             catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
