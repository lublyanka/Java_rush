package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
         //grandparents
        Human Tomas = new Human();
        Tomas.name = "Томас";
        Tomas.sex = true;
        Tomas.age = 42;

        Human Nigga = new Human();
        Nigga.name = "Нигга";
        Nigga.sex = true;
        Nigga.age = 42;

        Human Angela = new Human();
        Angela.name = "Анджела";
        Angela.sex = false;
        Angela.age = 39;

        Human Gopro = new Human();
        Gopro.name = "Гопро";
        Gopro.sex = false;
        Gopro.age = 39;


        //parents
        Human Nikita = new Human();
        Nikita.name = "Никита";
        Nikita.sex = true;
        Nikita.age = 42;
        Nikita.father = Tomas;
        Nikita.mother = Angela;

        Human Mishel = new Human();
        Mishel.name = "Мишель";
        Mishel.sex = false;
        Mishel.age = 39;
        Mishel.father = Nigga;
        Mishel.mother = Gopro;

    //children
        Human Anna = new Human();
        Anna.name = "Анна";
        Anna.sex = false;
        Anna.age = 10;
        Anna.father = Nikita;
        Anna.mother = Mishel;

        Human Kirill = new Human();
        Kirill.name = "Кирилл";
        Kirill.sex = true;
        Kirill.age = 10;
        Kirill.father = Nikita;
        Kirill.mother = Mishel;

        Human Nikolas = new Human();
        Nikolas.name = "Николай";
        Nikolas.sex = true;
        Nikolas.age = 21;
        Nikolas.father = Nikita;
        Nikolas.mother = Mishel;

        System.out.println(Tomas.toString());
        System.out.println(Nigga.toString());
        System.out.println(Angela.toString());
        System.out.println(Anna.toString());
        System.out.println(Gopro.toString());
        System.out.println(Nikita.toString());
        System.out.println(Mishel.toString());
        System.out.println(Nikolas.toString());
        System.out.println(Kirill.toString());

    }

    public static class Human
    {
        String name;
        boolean  sex;
        int age;
        Human father;
        Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
