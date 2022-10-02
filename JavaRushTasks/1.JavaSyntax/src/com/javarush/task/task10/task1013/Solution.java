package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private char sex;
        private int age;
        private double high;
        private double weight;
        private String name;
        private Human friend;

        public Human(char sex, int age, double high, double weight, String name, Human friend) {
            this.sex = sex;
            this.age = age;
            this.high = high;
            this.weight = weight;
            this.name = name;
            this.friend = friend;
        }

        public Human(char sex, int age, double high, double weight, String name) {
            this.sex = sex;
            this.age = age;
            this.high = high;
            this.weight = weight;
            this.name = name;
        }

        public Human(int age, double high, double weight, String name) {
            this.age = age;
            this.high = high;
            this.weight = weight;
            this.name = name;
        }

        public Human(char sex, int age, String name) {
            this.sex = sex;
            this.age = age;
            this.name = name;
        }

        public Human(char sex, String name, Human friend) {
            this.sex = sex;
            this.name = name;
            this.friend = friend;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public Human(String name, Human friend) {
            this.name = name;
            this.friend = friend;
        }

        public Human(char sex, String name) {
            this.sex = sex;
            this.name = name;
        }

        public Human(char sex, Human friend) {
            this.sex = sex;
            this.friend = friend;
        }
    }
}
