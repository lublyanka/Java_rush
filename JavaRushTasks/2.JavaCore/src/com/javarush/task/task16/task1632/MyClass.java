package com.javarush.task.task16.task1632;

public class MyClass {
    public static class TestClass extends Thread {

        public TestClass() {
            start();
        }

        public void run() {
            while (!isInterrupted()) {
                System.out.println("Class is working");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    this.interrupt();
                }
            }

        }

        public void cancel() {
            this.interrupt();
            //Thread.currentThread().interrupt();
            System.out.println("Stopped");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestClass testClass = new TestClass();
        Thread.sleep(3000);
        testClass.cancel();
    }
}