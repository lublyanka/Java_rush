package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

import com.sun.org.apache.bcel.internal.generic.SWITCH;

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();

    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;

            switch (country) {
                case  (Country.UKRAINE):
                    return new UkrainianHen();
                case (Country.MOLDOVA):
                    return new MoldovanHen();
                case (Country.RUSSIA):
                    return new RussianHen();
                case (Country.BELARUS):
                    return new BelarusianHen();
                default:
                    return new RussianHen();

            }


        }
    }


}
