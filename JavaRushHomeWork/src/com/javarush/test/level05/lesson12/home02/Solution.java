package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {

        Man man1 = new Man("Tony", 35, "LA");
        Man man2 = new Man("Anst", 25, "NY");
        Woman woman1 = new Woman("Lavi", 15, "Spb");
        Woman woman2 = new Woman("Mary", 27, "Moscow");

        System.out.println(man2.name + " " + man2.age + " " + man2.address);
        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(woman2.name + " " + woman2.age + " " + woman2.address);
        System.out.println(woman1.name + " " + woman1.age + " " + woman1.address);
    }


    public static class Man
    {
        String name, address;
        int age;

        public Man(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman
    {
        String name, address;
        int age;

        public Woman(String name, int age, String address)
        {
            this.name = name;
            this.address = address;
            this.age = age;
        }
    }
}
