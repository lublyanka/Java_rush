package com.javarush.task.task32.task3202;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(Files.newInputStream(Paths.get("d:/allFilesContent.txt")));
        System.out.println(writer);
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter result = new StringWriter();

        if(is != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            while (is.available() > 0) {
                result.write(bufferedReader.readLine());
            }
            result.flush();
        }
        return result;
    }
}
