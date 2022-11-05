package com.javarush.task.task31.task3112;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/test"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        Path tempfile = Files.createTempFile("tempfile_pass", ".txt");

        Files.copy(inputStream, tempfile, StandardCopyOption.REPLACE_EXISTING);

        Path resfile = Files.move(tempfile,
                Paths.get(downloadDirectory.toString() + urlString.substring(urlString.lastIndexOf("/"))),
                StandardCopyOption.REPLACE_EXISTING);


        inputStream.close();
        return (Files.size(resfile) > 0) ? resfile : null;
        }
}
