package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

import java.util.concurrent.atomic.AtomicInteger;

public class Solution_Atomic {
    static int count = 15;
    public static volatile AtomicInteger createdThreadCount = new AtomicInteger(0); // нужен ли volatile - не нужен тут


    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{

        public  GenerateThread(){
            super(String.valueOf(createdThreadCount.incrementAndGet()));
            //createdThreadCount.incrementAndGet; // работает и с ней и без (//а вот и нет, работало только из-за блока synchronized ниже в run
            start();
        }


        @Override
        public String toString (){
            return this.getName() + " created";
        }
        @Override
        public void run(){
            while (createdThreadCount.get() < count)
            {
                     System.out.println(new GenerateThread());
            }
        }
    }
}
