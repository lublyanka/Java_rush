package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
В методе main добавить в статический объект list 5 нитей. Каждая нить должна быть новым объектом класса Thread, работающим со своим объектом класса SpecialThread.


Requirements:
1. В методе main создай 5 объектов типа SpecialThread.
2. В методе main создай 5 объектов типа Thread.
3. Добавь 5 разных нитей в список list.
4. Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
5. Класс SpecialThread изменять нельзя.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {

            Thread thread1 = new Thread(new SpecialThread());
            thread1.run();
            list.add(thread1);
            Thread thread2 = new Thread(new SpecialThread());
            thread2.run();
            list.add(thread2);
            Thread thread3 = new Thread(new SpecialThread());
            thread3.run();
            list.add(thread3);
            Thread thread4 = new Thread(new SpecialThread());
            thread4.run();
            list.add(thread4);
            Thread thread5 = new Thread(new SpecialThread());
            thread5.run();
            list.add(thread5);

        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
