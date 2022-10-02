package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
В этой задаче тебе нужно:
Считать с консоли путь к файлу.
Вывести в консоли (на экран) содержимое файла.
Освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.

Requirements:
1. Программа должна считывать c консоли путь к файлу.
2. Программа должна выводить на экран содержимое файла.
3. Поток чтения из файла (FileInputStream) должен быть закрыт.

*/

public class Solution {
    public static void main(String[] args) {
        Solution myObject = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathS="";
        try {
            pathS = reader.readLine();
            reader.close();
        }
        catch (IOException e)
        {
           System.out.println(e.getCause());
        }

        try {
            InputStream inputStream = new FileInputStream(pathS);

            while (inputStream.available() > 0){
                int data;

                data = inputStream.read();
                System.out.print((char)data);
            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}