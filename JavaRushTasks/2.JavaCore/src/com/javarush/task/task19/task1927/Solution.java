package com.javarush.task.task19.task1927;

import java.io.*;
import java.util.Scanner;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

       PrintStream original = System.out;

       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
       PrintStream printStream = new PrintStream(byteArrayOutputStream);
       System.setOut(printStream);

       testString.printSomething();
       System.setOut(original);

       BufferedReader reader =  new BufferedReader(
               new InputStreamReader(
               new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));

       int i=1;
       while (reader.ready()){
           System.out.println (reader.readLine());
           if (i%2 ==0) {
               System.out.println("JavaRush - курсы Java онлайн");
           }
           i++;

       }

       //JR решение
       /* String[] byteArray = byteArrayOutputStream.toString().split("\\n");
        for (int i = 0; i < byteArray.length; i++) {
            System.out.println(byteArray[i]);
            if (i % 2 != 0)
                System.out.println("JavaRush - курсы Java онлайн");
        }*/

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
