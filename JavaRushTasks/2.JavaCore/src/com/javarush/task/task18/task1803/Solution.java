package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        int maxByte;
        String resultString = null;
        HashMap<Integer, Integer> bytesFrequency = new HashMap<Integer, Integer>();

        try {
            fileName = reader.readLine();
        } catch (IOException e) {
        }

        FileInputStream fileInputStream = new FileInputStream(fileName);

        while (fileInputStream.available() > 0) {
            int currentByte = fileInputStream.read();
            bytesFrequency.merge(currentByte, 1, Integer::sum);
        }

        maxByte = bytesFrequency.entrySet().stream().max((entry1, entry2) -> entry1.getValue() - entry2.getValue()).get().getValue();

        for (Map.Entry<Integer, Integer> entry : bytesFrequency.entrySet()) {
            if (entry.getValue() == maxByte) {
                if (resultString == null) {
                    resultString = entry.getKey().toString();
                } else
                    resultString = String.join(" ", resultString, entry.getKey().toString());
            }
        }

        //кааааак

        /*String ar = bytesFrequency.entrySet().stream()
                .filter(v -> v.getValue() == maxByte)
                .map(v -> v.getKey().toString())
                .reduce("", (a, b)  ->
                        String.join(" ", a, b));

        String ar1 = bytesFrequency.entrySet().stream()
                .filter(v -> v.getValue() == maxByte)
                .map(v -> v.getKey().toString())
                .collect(
                        StringBuilder::new,
                        (stringBuilder, s) -> {
                            if (stringBuilder.length() > 0) {
                                stringBuilder.append(" ");
                            }
                            stringBuilder.append(s);
                        },
                        (stringBuilder, stringBuilder2) -> stringBuilder.append(" ").append(stringBuilder2))
                .toString();*/

        System.out.println(resultString);
        /*System.out.println(ar);
        System.out.print(ar1);*/

        fileInputStream.close();
    }
}

