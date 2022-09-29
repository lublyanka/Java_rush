package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human children1 = new Human();
        Human children2 = new Human();
        Human children3 = new Human();
        Human father = new Human();
        Human mother = new Human();
        father.children.add(children1); father.children.add(children2); father.children.add(children3);
        mother.children.add(children1); mother.children.add(children2); mother.children.add(children3);
        Human grandfather1 = new Human();
        Human grandmother1 = new Human();
        Human grandfather2 = new Human();
        Human grandmother2 = new Human();
        grandfather1.children.add(father); grandfather2.children.add(mother);
        grandmother1.children.add(father); grandmother2.children.add(mother);

        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
