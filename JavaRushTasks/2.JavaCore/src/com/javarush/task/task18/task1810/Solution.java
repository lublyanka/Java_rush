package com.javarush.task.task18.task1810;

import java.io.*;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isClosed = false;
        while (!isClosed){
            try {
                String filename="";
                byte[] buffer = new byte[1000];

                filename = reader.readLine();

                FileInputStream fileInputStream = new FileInputStream(filename);
                if (fileInputStream.read(buffer) < 1000)
                {
                        isClosed = true;
                        fileInputStream.close();
                        throw  new DownloadException();
                }

            } catch (IOException e) {
               ;
            }
        }

       /* while (true) {
            String fileName = reader.readLine();

            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                if (fileInputStream.available() < 1000) throw new DownloadException();
            }
        }*/

    }

    public static class DownloadException extends Exception {

    }
}
