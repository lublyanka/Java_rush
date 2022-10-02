package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

import java.util.Date;

public class Solution {
    public static volatile int numSeconds = 10
            ;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }


    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            try {
                    while (numSeconds > 0) {
                        System.out.print(numSeconds + " ");
                        numSeconds -= 1;
                        Thread.sleep(1000);
                    }
                    System.out.print("Марш!");
            } catch (InterruptedException e) {
                System.out.print("Прервано!");
            }

               /* Date starttime = new Date();

                while ((new Date().getTime() - starttime.getTime()) < 3500 && numSeconds > 0) {
                            try {
                                System.out.print(numSeconds + " ");
                                numSeconds -= 1;
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                if((new Date().getTime() - starttime.getTime()) < 3500 && numSeconds == 0)
                        System.out.print("Марш!");
                else
                    System.out.print("Прервано!");*/
            }
        }
    }

