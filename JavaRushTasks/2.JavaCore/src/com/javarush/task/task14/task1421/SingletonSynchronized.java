package com.javarush.task.task14.task1421;

public class SingletonSynchronized {
    private static SingletonSynchronized instance;

    public static synchronized SingletonSynchronized getInstance() {
        if (instance == null) {
            instance=new SingletonSynchronized();
        }
    return instance;
    }
}
