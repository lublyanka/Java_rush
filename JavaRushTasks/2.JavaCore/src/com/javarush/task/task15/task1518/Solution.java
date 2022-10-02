package com.javarush.task.task15.task1518;

/* 
Статики и котики
*/

public class Solution {
    public static Cat cat;

    public static class Cat {
        public String name;
    }

    static {
        Cat kitty = new Cat();
        cat = kitty;
        cat.name = "Pirat";
        System.out.println(cat.name);
    }

    public static void main(String[] args) {

    }
}
