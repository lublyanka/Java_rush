package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       ArrayList<String> myList = new ArrayList<>(10);
       int minStringIndex=0, maxStringIndex=0;
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       for (int i = 0; i < 10; i++)
       {
            myList.add(reader.readLine());
       }

       for (int i = 0; i < myList.size(); i++)
        {
            if (myList.get(i).length() < myList.get(minStringIndex).length())
                minStringIndex=i;
            else if (myList.get(i).length() > myList.get(maxStringIndex).length())
                maxStringIndex=i;
        }

       System.out.println(minStringIndex<maxStringIndex?myList.get(minStringIndex):myList.get(maxStringIndex));
    }
}
