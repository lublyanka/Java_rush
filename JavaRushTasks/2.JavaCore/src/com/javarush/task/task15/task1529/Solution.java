package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
       reset();
    }

    public static CanFly result;

    public static void reset() {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();
            if(line.equals("helicopter"))
            {result = new Helicopter();}
            else if (line.equals("plane"))
            {int number = Integer.parseInt(reader.readLine());
                result = new Plane(number);}
            reader.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
