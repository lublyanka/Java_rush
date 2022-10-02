package com.javarush.task.task14.task1408;

public class RussianHen extends Hen{

    int getCountOfEggsPerMonth() {
        return 150;
    }

    public  String getDescription(){
        Hen desc = new RussianHen();

        return
                ( super.getDescription()
                        + " Моя страна - " + Country.RUSSIA
                        +". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");}
}
