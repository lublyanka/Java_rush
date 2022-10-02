package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String line = reader.readLine();
        ArrayList<Character> vowelsList = new ArrayList<>();
        ArrayList<Character> consonantsList = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if(isVowel(line.charAt(i)))
                vowelsList.add(line.charAt(i));
            else if (!(line.charAt(i) == ' '))
                consonantsList.add(line.charAt(i));
        }
        vowelsList.forEach((n)-> System.out.print(n+" "));
        System.out.println();
        consonantsList.forEach((n)-> System.out.print(n+" "));

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char vowel : vowels) {  // ищем среди массива гласных
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}