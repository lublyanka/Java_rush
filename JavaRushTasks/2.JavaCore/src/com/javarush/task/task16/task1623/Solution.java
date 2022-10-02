package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    //static volatile int createdThreadCount=1;
    static volatile int createdThreadCount=0;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{

        public  GenerateThread(){
            super(String.valueOf(++createdThreadCount));
            start();
        }


        @Override
        public String toString (){
            return this.getName() + " created";
        }
        @Override
        public void run(){
            //while (createdThreadCount < count)  //с этой строкой не принимает
            //{ //с этой строкой не принимает
                synchronized (GenerateThread.class){
                    if((createdThreadCount < count))
                        System.out.println(new GenerateThread());}
            //} //с этой строкой не принимает
        }
    }
}
