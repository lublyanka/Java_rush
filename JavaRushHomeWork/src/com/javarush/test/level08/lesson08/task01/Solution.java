package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        Set<String> lMap = new HashSet<String>();

       /* for(int i = 0; i < 20; i++)
        {
            lMap.add("Лев");
        }     */

        lMap.add("Любовь");
        lMap.add("Лодка");
        lMap.add("Лошадь");
        lMap.add("Лось");
        lMap.add("Лиса");
        lMap.add("Люди");
        lMap.add("Лихо");
        lMap.add("Лама");
        lMap.add("Лак");
        lMap.add("Ладан");
        lMap.add("Лавочка");
        lMap.add("Леший");
        lMap.add("Лучший");
        lMap.add("Лекарство");
        lMap.add("Литавры");
        lMap.add("Лик");
        lMap.add("Лыко");
        lMap.add("Ложь");
        lMap.add("Лесть");
        lMap.add("Лымарь");

        return  (HashSet)lMap;
    }
}
