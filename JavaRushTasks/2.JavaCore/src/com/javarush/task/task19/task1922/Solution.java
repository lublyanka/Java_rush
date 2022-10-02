package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(filename))){


            while (reader1.ready()){
                String row = reader1.readLine();
                int count=0;
                for (String wordDict: words) {
                    for (String wordMatch: row.split(" ")) {
                        if(wordDict.equals(wordMatch))
                            count++;
                    }
                }

                if (count==2)
                    System.out.println(row);
            }
        }

    }
}
