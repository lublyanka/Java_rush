package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line.toLowerCase());
        }

        HashMap<Character, Integer> counterList = new HashMap<Character,Integer>();
        for (Character sign:alphabet) {
            counterList.put(sign,0);
        }
        for (String line:list
             ) {
            line.toLowerCase();
            for (int i = 0; i < line.length(); i++) {
                if(alphabet.contains(line.charAt(i)))
                    counterList.put(line.charAt(i), counterList.get(line.charAt(i))+1);
            }
        }
        for (Character sign:alphabet) {
            System.out.println(sign+" "+ counterList.get(sign));
        }
        //counterList.forEach((sign,count) -> System.out.println(sign+" "+count));


        }
    }

