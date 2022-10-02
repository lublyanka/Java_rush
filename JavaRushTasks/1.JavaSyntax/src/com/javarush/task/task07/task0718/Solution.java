package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> myList = new ArrayList<String>(10);
        int result = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {

            String input = reader.readLine();
            myList.add(input);
            //System.out.printf("(%1$d) You typed: %2$s\r\n", i, input);
        }

        if (myList.size() < 10)
            throw new Exception("asdasdasd");
        else {
            System.out.println("++++++++++++++++++++++");
            for(String s : myList)
            {
                System.out.println(s);
            }
        }
        
       /* for (int i=0; i < myList.size(); i++)
        {
           if (myList.get(i).length() >=  myList.get(result).length())
           {
               result= i ;
           }
           else {
               System.out.println(i);
               break;
           }
        }*/

        String bugString = myList.get(0);

        for (int i = 1; i < 10; i++) {
            if (myList.get(i).length() >= bugString.length()) {
                bugString = myList.get(i);
            } else {
                System.out.println(i);
                break;
            }
        }
    }
}
