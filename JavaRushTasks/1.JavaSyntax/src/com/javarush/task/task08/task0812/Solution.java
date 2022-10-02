package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       List <Integer> myList = new ArrayList<Integer>();
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       int line = 1,resline =1;
        for (int i=0; i <10;i++) {
            myList.add(Integer.parseInt(reader.readLine()));
            System.out.println("");
        }

        for (int i=0; i <9;i++)
        {
            if (myList.get(i).equals(myList.get(i+1)))
            {   line++;
                if (resline < line)
                    resline=line;}
            else
                line=1;
        }
        System.out.println(resline);
    }
}
