package com.javarush.test.level05.lesson05.task05;

/* Провести три боя  попарно между котами
Создать три кота используя класс Cat.
Провести три боя попарно между котами.
Класс Cat создавать не надо. Для боя использовать метод boolean fight(Cat anotherCat).
Результат каждого боя вывести на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Cat catVasya = new Cat("Vasya", 6, 5, 1 );
        Cat catMasha = new Cat("Masha", 2, 3, 2 );
        Cat catPing = new Cat("Ping", 2, 3, 4 );
        boolean resultFirstFight = catVasya.fight(catMasha);
        boolean resultSecondFight = catPing.fight(catMasha);
        boolean resultThirdFight = catPing.fight(catVasya);
        System.out.println(resultFirstFight);
        System.out.println(resultSecondFight);
        System.out.println(resultThirdFight);
    }

    public static class Cat {

        public static int count = 0;
        public static int fightCount = 0;

        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            fightCount++;

            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

            int score = agePlus + weightPlus + strengthPlus;
            return score > 2 ? true : false;
        }
    }
}
