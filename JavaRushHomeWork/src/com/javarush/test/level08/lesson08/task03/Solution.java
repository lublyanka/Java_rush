package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        Map<String, String> dictionary= new HashMap<String,String>();
        dictionary.put("Синий","Василек");
        dictionary.put("Розовая","Ровиола");
        dictionary.put("Красная","Бурбонетка");
        dictionary.put("Зеленый","Криоген");
        dictionary.put("Шампань","Шакро");
        dictionary.put("Серебристый","Бук");
        dictionary.put("Лазурный","Шато");
        dictionary.put("Фиолетовый","Мерлин");
        dictionary.put("Жадный","Карпаччо");
        dictionary.put("Суровый","Моцарт");
        return (HashMap)dictionary;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int counter = 0;
        for(Map.Entry meMap : map.entrySet())
        {
            if (meMap.getValue() == name)
                counter++;
        }
        return  counter;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int counter = 0;
        for(Map.Entry meMap : map.entrySet())
        {
            if (meMap.getKey() == familiya)
                counter++;
        }
        return  counter;

    }
}
