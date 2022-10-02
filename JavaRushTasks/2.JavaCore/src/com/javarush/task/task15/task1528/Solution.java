package com.javarush.task.task15.task1528;

/* 
ООП. Hryvnia — тоже деньги
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Hryvnia().getAmount());
    }

    //private static Money get() { return new Hryvnia();}

    public static abstract class Money {
        abstract Money getMoney();

        public Object getAmount() {
            return getMoney().getAmount();
        }
    }

    //add your code below - добавь код ниже
    public static class Hryvnia extends Money {
        private double amount = 123d;

        public Hryvnia getMoney() {
            return this;
        }

        public Double getAmount() {
            return this.amount;
        }
    }
}

