package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        //get filename to writeIN
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream original = System.out;

        //создаем адаптер к классу PrintStream
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArray);

        //Устанавливаем его как текущий System.out
        System.setOut(printStream);

        testString.printSomething();

        try(FileOutputStream streamWriter = new FileOutputStream(filename)){
            streamWriter.write(byteArray.toByteArray());
        }

        System.setOut(original);

        System.out.println(byteArray);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}