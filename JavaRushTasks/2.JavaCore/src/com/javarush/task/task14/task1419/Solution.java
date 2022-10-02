package com.javarush.task.task14.task1419;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = Integer.parseInt("as") / 0;

        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
        catch (Exception e) {
            exceptions.add(e);
        }
        try {
            float i = 1 / 0;

        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Integer arrays[] = new Integer[2];
            for (int i = 0; i < arrays.length; i++) {
                System.out.println(arrays[i-1]);
            }

        } catch (RuntimeException e) {
            exceptions.add(e);
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        exceptions.add(new IllegalArgumentException());
        exceptions.add(new IllegalAccessException());
        exceptions.add(new ClassCastException());
        exceptions.add(new IOException());
        exceptions.add(new InterruptedIOException());
        exceptions.add(new InterruptedException());
        exceptions.add(new SecurityException());
    }
}
