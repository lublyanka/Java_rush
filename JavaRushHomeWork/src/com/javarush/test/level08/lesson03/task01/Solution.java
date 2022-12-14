package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        HashSet<String> bag = new HashSet<String>();
        bag.add("арбуз");
        bag.add("банан");
        bag.add("вишня");
        bag.add("груша");
        bag.add("дыня");
        bag.add("ежевика");
        bag.add("жень-шень");
        bag.add("земляника");
        bag.add("ирис");
        bag.add("картофель");

        bag.size();
        for( String i : bag)
        {
            System.out.println(i);
        }

    }
}
