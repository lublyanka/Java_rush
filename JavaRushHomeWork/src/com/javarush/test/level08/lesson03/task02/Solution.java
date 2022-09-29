package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз – ягода, банан – трава, вишня – ягода, груша – фрукт, дыня – овощ, ежевика – куст, жень-шень – корень, земляника – ягода, ирис – цветок, картофель – клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель – овощ
*/

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        HashMap <String, String> bag = new HashMap<String, String>();
        bag.put("арбуз","ягода");
        bag.put("банан","трава");
        bag.put("вишня","ягода");
        bag.put("груша","фрукт");
        bag.put("дыня","овощ");
        bag.put("ежевика","куст");
        bag.put("жень-шень","корень");
        bag.put("земляника","ягода");
        bag.put("ирис","цветок");
        bag.put("картофель","клубень");

        for(Map.Entry me : bag.entrySet())
        {
             System.out.println(me.getKey() + " - " + me.getValue());
        }
    }
}
