package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Джерард", new Date("JULY 1 1980"));
        map.put("Алькапоне", new Date("AUGUST 1 1980"));
        map.put("Редьков", new Date("SEPTEMBER 1 1980"));
        map.put("Маркс", new Date("NOVEMBER 1 1980"));
        map.put("Джованни", new Date("DECEMBER 1 1980"));
        map.put("Петрино", new Date("APRIL 1 1980"));
        map.put("Редмондс", new Date("MAY 1 1980"));
        map.put("Буковски", new Date("FEBRUARY 1 1980"));
        map.put("Виноградов", new Date("MARCH 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
           Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();
           while(iterator.hasNext())
           {
               int month = iterator.next().getValue().getMonth()+1;
               if( 5 < month && month < 9)
                    iterator.remove();
           }
    }

    /*public static void main(String[] args)
    {
        HashMap mapMap = createMap();
        removeAllSummerPeople(mapMap);
        System.out.println(mapMap);
    }  */
}
