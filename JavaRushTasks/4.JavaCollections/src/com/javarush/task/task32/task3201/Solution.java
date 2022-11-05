package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        // путь к файлу;
        String filename = args[0];
        //число, позиция в файле;
        long number = Long.parseLong(args[1]);
        //текст
        String text = args[2];

        try (RandomAccessFile accessFile = new RandomAccessFile(filename,"rw" )){
            long length = accessFile.length();

            if ((length < number)) {
                accessFile.seek(length);
            } else {
                accessFile.seek(number);
            }

            accessFile.write(text.getBytes(StandardCharsets.UTF_8));
        }

    }
}
