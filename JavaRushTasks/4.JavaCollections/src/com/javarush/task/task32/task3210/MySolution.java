package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class MySolution {
    public static void main(String... args) {
        // путь к файлу;
        String filename = args[0];
        //число, позиция в файле;
        long number = Long.parseLong(args[1]);
        //текст
        String text = args[2];

        long textLenght = text.length();

        try (RandomAccessFile accessFile = new RandomAccessFile(filename,"rw" )){
            long length = accessFile.length();
            byte[] buff = new byte[256];
            int count=256;
            StringBuilder textFromFile = new StringBuilder();

            accessFile.seek(number);
            while((count=accessFile.read(buff)) >0 && textLenght > 0){
                textFromFile.append(new String(buff,0, count));
                textLenght -= count;
            };
            textFromFile.setLength(text.length());


            accessFile.seek(length);
            if(text.equals(textFromFile)){
                accessFile.write("true".getBytes());
            }
            else {
                accessFile.write("false".getBytes());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
