package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream original = System.out;

        //создаем адаптер к классу PrintStream
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(byteArray);

        //Устанавливаем его как текущий System.out
        System.setOut(newStream);

        testString.printSomething();

        String result ;
        String [] numbers = byteArray.toString().split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[2]);
        int c;
        if (numbers[1].equals("+"))
            c = a + b;
        else if (numbers[1].equals("-"))
            c = a - b;
        else if (numbers[1].equals("*"))
            c = a * b;
        else
            throw new IllegalArgumentException("Ожидался + или - в качестве операции");

        System.setOut(original);

        result = String.join( " ", numbers[0], numbers[1], numbers[2], numbers[3], String.valueOf(c));
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

