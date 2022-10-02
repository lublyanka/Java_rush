package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/* 
Для решения этой задачи:
Инициализируй переменную Statics.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
В статическом блоке считай из файла с именем Statics.FILE_NAME все строки и добавь их по отдельности в List lines.

Requirements:
1. Константа FILE_NAME не должна быть пустой.
2. В статическом блоке все строки из файла с именем FILE_NAME должны быть добавлены по отдельности в список lines.
3. Поле FILE_NAME НЕ должно быть final.
4. Класс Solution должен содержать список lines.
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static
    {
        try {
            FileReader inputFileReader = new FileReader(Statics.FILE_NAME);
            BufferedReader reader = new BufferedReader(inputFileReader);
            while(reader.ready()) {
                lines.add(reader.readLine());
            }
            reader.close();
            inputFileReader.close();
            }
        catch (FileNotFoundException e)
        {}
        catch (IOException e)
        {}
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
