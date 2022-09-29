package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution
{
    public static void main(String[] args)
    {
        String  a1 = "Мама", a2 = "Мыла", a3 = "Раму" ;
        String[] allStrings = new String[]{a1, a2, a3};
        for(int  i = 1; i < 4; i++)
        {
            for(int j = 1; j < 4; j++)
            {
                {
                    for(int k = 1; k < 4; k++)
                    {

                        if((j!=i)&&(k!=i)&&(k!=j))
                        {
                            System.out.print(allStrings[i-1]+ allStrings[j-1] + allStrings[k-1]);
                            System.out.println();}
                    }
                }


            }

        }
    }

}