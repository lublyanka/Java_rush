package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap map = new HashMap();
        map.put("Васильев","Иван");
        map.put("Сумачов","Иван");
        map.put("Верблюдов","Александр");
        map.put("Жуликов","Иван");
        map.put("Поле","Кулик");
        map.put("Арбузов","Сергей");
        map.put("Жмыхарь","Виталий");
        map.put("Павлов","Судьба");
        map.put("Бытовой","Олег");
        map.put("Занудов","Иван");

    return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy1 = new HashMap<String, String>(map);
        ArrayList[] value = new ArrayList[map.size()];
        map.values().toArray(value);
       for(int q = 0; q < value.length; q++)
            for (Map.Entry<String, String> pair: copy1.entrySet())
            {
                if (pair.getValue().equals(q))
            map.remove(pair.getKey());
             }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
