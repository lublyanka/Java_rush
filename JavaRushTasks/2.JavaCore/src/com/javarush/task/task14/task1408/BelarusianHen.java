package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen{

     int count = getCountOfEggsPerMonth();
     int getCountOfEggsPerMonth() {
        return 50;
    }
 @Override
    public String getDescription(){

         return
                ( super.getDescription()
                + " Моя страна - " + Country.BELARUS
                +". Я несу " + count + " яиц в месяц.");}
}
