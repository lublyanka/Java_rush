package com.javarush.test.level07.lesson06.task01;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList <String> list = new ArrayList();
        list.add("pmnom");
        list.add("nabnab");
        list.add("rerer");
        list.add("fsfsfsf");
        list.add("omtestnom");
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        };
    }
}
