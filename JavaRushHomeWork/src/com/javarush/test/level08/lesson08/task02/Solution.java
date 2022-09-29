package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;


/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        Set<Integer> setGlobal = new HashSet();

        for(int i = 0; i < 20; i++)
        {
            setGlobal.add(i);
        }

        return (HashSet<Integer>)setGlobal;
    }

    public static HashSet<Integer> removeAllNumbersMoreThen10(HashSet<Integer> set)
    {
        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
        int element = (Integer)iterator.next();
        if(element > 10)
        {
            iterator.remove();
        }

        }

    return set;
    }
}
