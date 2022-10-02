package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.TreeMap;

/*
Встречаемость символов
*/

public class MySolution {

    final static TreeMap <Integer, Integer> symbolsMap = new TreeMap<>();
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(args[0])){
            while (fileInputStream.available() > 0) {
                symbolsMap.merge(fileInputStream.read(), 1, Integer::sum);
            }

            symbolsMap.forEach( (k,v) -> { if (k >=0 && k <= 127)
                System.out.println((char)(int) k + " " + v);});

        }

        catch (FileNotFoundException fileNotFoundException) {

        }
        catch (IOException ioException) {

        }
    }
}
