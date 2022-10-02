package com.javarush.task.task18.task1816;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* 
Английские буквы
65-90
97-122
*/

public class Solution {
    private static int englishCounter=0;
    public static void main(String[] args) throws WrongNumberArgsException {

        if (args.length ==0 || args.length < 1) {
            throw  new WrongNumberArgsException("2");
        }

        try (FileInputStream inputStream = new FileInputStream(args[0])) {
            while (inputStream.available() > 0) {
                int currentSymbolInt = inputStream.read();
                //if (Pattern.matches("[a-zA-Z]", String.valueOf((char)currentSymbolInt))) //а тут норм
                //Character.isAlphabetic(currentSymbolInt);  //тут надо еще условие на Eng

                //а здесь MagicNumbers
                if (((currentSymbolInt >= 65) && (currentSymbolInt <= 90)) || ((currentSymbolInt >= 97) && (currentSymbolInt <= 122))) {
                    englishCounter++;
                }
            }

        System.out.println(englishCounter);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
