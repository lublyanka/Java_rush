package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //String paramRow = url.substring(url.indexOf("?")+1);
        ArrayList<String[]> paramListArray = new ArrayList<String[]>();
        ArrayList<String> paramRowArray = new ArrayList<String>();
        //paramRowArray.addAll(Arrays.asList(paramRow.split("&")));
        paramRowArray.addAll(Arrays.asList(url.substring(url.indexOf("?")+1).split("&")));
        if (!paramRowArray.isEmpty())
            for (int i = 0; i < paramRowArray.size(); i++) {
                paramListArray.add(paramRowArray.get(i).split("=",2));
            }


        //String resultString123=String.join(" ",paramListArray.stream().map(row -> row[0]).toArray(String[]::new));
        String resultString="";
        for (String[] array : paramListArray) {
            resultString=resultString.concat(array[0]+" ");
        }
        System.out.println(resultString.trim());
        //System.out.println(resultString123);
        paramListArray.forEach(array -> {
            if (array[0].equals("obj"))
                try{if ((Double.valueOf(array[1])) instanceof Double)
                    alert(Double.valueOf(array[1]));
                }
                catch (NumberFormatException e) {
                    alert(array[1]);
                };
        });
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
