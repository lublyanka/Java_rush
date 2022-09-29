package com.javarush.test.level07.lesson12.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача:  Программа вводит с клавиатуры данные про котов и выводит их на экран. Пример:
Cat name is Barsik age is 6, weight is 5, tail = 22
Cat name is Murka age is 8, weight is 7, tail = 20
*/

            public class Solution
            {
                public final static ArrayList<Cat> CATS = new ArrayList<Cat>();

                public static void main(String[] args) throws IOException
                {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String ageS, weightS, tailLengthS;

                    while (true)
        {
            String name = reader.readLine();
            ageS = reader.readLine();
            weightS = reader.readLine();
            tailLengthS = reader.readLine();
            if (name.isEmpty()) break;
            Cat cat = new Cat(name, ageS, weightS, tailLengthS);
            CATS.add(cat);

        }

        printList();
    }

    public static void printList() {
        for (int i = 0; i < CATS.size(); i++)
        {
            System.out.println(CATS.get(i));
        }
    }

    public static class Cat
    {
        private String name;
        private String age;
        private String weight;
        private String tailLength;

        Cat(String name, String age, String weight, String tailLength)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.tailLength = tailLength;
        }

        @Override
        public String toString()
        {
            return "Cat name is " + name + ", age is " + age + ", weight is " + weight + ", tail = " + tailLength;
        }
    }
}
