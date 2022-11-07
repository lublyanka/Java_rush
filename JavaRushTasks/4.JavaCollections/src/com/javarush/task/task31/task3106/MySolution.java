package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class MySolution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];

        ArrayList<String> zipParts = new ArrayList<>();
        zipParts.addAll(Arrays.asList(args).subList(1, args.length));
        Collections.sort(zipParts);

        //get the whole zip inside byteArrayOutStream

        File your_file_name = File.createTempFile("your_file_name", null);
        try (FileOutputStream fileOutputStream = new FileOutputStream(your_file_name);
             FileChannel fchanel = fileOutputStream.getChannel();) {
            for (String filename : zipParts) {
                FileInputStream fileInputStream = new FileInputStream(filename);
                fileInputStream.getChannel().transferTo(0, fileInputStream.available(), fchanel);
            }
        }


        try (FileInputStream fileInputStream = new FileInputStream(your_file_name);
             ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
             FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);) {

            byte[] buffer = new byte[10240];

            ZipEntry entry = zipInputStream.getNextEntry();

            int read;
            while ((read = zipInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, read);
            }
        }
    }
}

