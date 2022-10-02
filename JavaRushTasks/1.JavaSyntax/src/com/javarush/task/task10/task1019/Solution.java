package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String,Integer>  map = new HashMap<String,Integer>();
        //map.put(String[],String()[]);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            int id=0;
            try {
            id = Integer.parseInt(reader.readLine());//System.out.println();
                }
            catch (NumberFormatException e)
           {reader=null; break;}
            /*finally {
                map.put("",id);
            }*/
            String name = reader.readLine(); //System.out.println();
           // if (name.equals("")) {reader=null; break;}

            map.put(name,id);
        }



        //System.out.println("Id=" + id + " Name=" + name);*/
        map.forEach((key, value) -> System.out.println(value + " " + key));
        //
    }
}
