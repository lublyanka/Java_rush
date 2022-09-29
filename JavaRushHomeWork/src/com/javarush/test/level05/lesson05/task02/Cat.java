package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat()
    {
    }

    public boolean fight (Cat anotherCat)
    {
        int ageResultOfFight;
        int weightResultOfFight;
        int strengthResultOfFight;
        if (this.age > anotherCat.age)
            ageResultOfFight = 1;
        else
            ageResultOfFight = 0;
        if (this.weight > anotherCat.weight)
            weightResultOfFight = 1;
        else
            weightResultOfFight = 0;
        if (this.strength > anotherCat.strength)
            strengthResultOfFight = 1;
        else
            strengthResultOfFight = 0;
        int allInResultOfFight = ageResultOfFight + weightResultOfFight + strengthResultOfFight;
        if (allInResultOfFight > 2)
            return true;
        else
            return false;
    }
}
