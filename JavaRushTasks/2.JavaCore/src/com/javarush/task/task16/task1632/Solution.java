package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {

        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        Thread thread3 = new Thread();
        Thread thread4 = new Thread();
        Thread thread5 = new Thread();

        threads.add(new EndlessLoop());
        threads.add(new IE());
        threads.add(new Hurray());
        threads.add(new MessageExample());
        threads.add(new Reader());
    }

    static class EndlessLoop extends Thread //implements Runnable
    {

        public void run() {
            while (true) {
                Thread.currentThread().getState();
            }
        }
    }

    static class IE extends Thread //implements Runnable
    {
        private String string = "InterruptedException";

        public void run() {
            if (Thread.currentThread().isInterrupted()) {
                System.out.format("%s", string);
            }
            ;
        }
    }

    static class Hurray extends Thread  //implements Runnable
    {
        private String string = "Ура";

        public void run() {
            try {
                while (true) {
                    System.out.format("%s", string);
                    System.out.println();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    static class Reader extends Thread //implements Runnable
    {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String row = "";
            int result = 0;
            try {
                while (!(row = reader.readLine()).equals("N")) {
                    result = Integer.parseInt(row) + result;

                }
                System.out.println(result);
            } catch (IOException e) {

            }
        }
    }


   /* static class MessageExample implements Message, Runnable{

        @Override
        public void showWarning() {

            Thread.currentThread().interrupt();
        }

        @Override
        public void run() {

        }
    }*/

    static class MessageExample extends Thread implements Message {

        @Override
        public void showWarning() {

            this.interrupt();
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
            }
        }
    }



    public static void main(String[] args) {
       //threads.get(3).start();
       //new MessageExample().showWarning();

        }



}
