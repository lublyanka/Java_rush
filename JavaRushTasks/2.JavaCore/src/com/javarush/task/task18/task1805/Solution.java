package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename;
        Set<Integer> bytes = new TreeSet<Integer>();
        String resultString=null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            filename = reader.readLine();
        }

        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
            while (fileInputStream.available() > 0)
            {
                bytes.add(fileInputStream.read());
            }
        }

        for (Integer entry: bytes) {
            if (resultString == null) {
                resultString = entry.toString();
            } else
                resultString = String.join(" ", resultString, entry.toString());
        }

        System.out.print(resultString);

    }
}
