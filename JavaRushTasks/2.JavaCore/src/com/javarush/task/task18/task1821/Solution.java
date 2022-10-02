package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {

    final static TreeMap <Integer, Integer> symbolsMap = new TreeMap<>();
    public static void main(String[] args) {

        int[] aSCII = new int[128];
        int row=0;
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                while ((row=reader.read()) < 127 && row >= 0)
                aSCII[row]++;
            }

            for (int i = 0; i < aSCII.length; i++) {
                if (aSCII[i] != 0) {
                    System.out.println((char) i + " " + aSCII[i]);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(row);
        }
        catch (FileNotFoundException fileNotFoundException) {

        }
        catch (IOException ioException) {

        }
    }
}
