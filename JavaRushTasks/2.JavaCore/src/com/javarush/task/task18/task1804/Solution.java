package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        String resultString=null;

        try {
             fileName = reader.readLine();
        } catch (IOException e){
            System.out.println("Имя файла не считано");
        }

        //if(fileName != null){
            FileInputStream fileInputStream = new FileInputStream(fileName);
            HashMap<Integer,Integer> byteFrequency = new HashMap<>();

            while (fileInputStream.available()>0)
            {
                byteFrequency.merge(fileInputStream.read(),1,Integer::sum);
            }
            fileInputStream.close();

            int minAmount= byteFrequency.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue)).get().getValue();
            //System.out.print(minAmount);
            for (Map.Entry<Integer,Integer> entry : byteFrequency.entrySet()) {
                if(entry.getValue()==minAmount){
                    if(resultString==null){
                        resultString=entry.getKey().toString();}
                    else
                        resultString=String.join(" ", resultString, entry.getKey().toString());}
                }

        //}

            System.out.print(resultString);
        //reader.close();

        }


}

