package com.javarush.task.task10.task1007;

/* 
Задача №7 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        long l = (int) 1234_564_890L;
        int x = 0b1000_1100_1010;
        double m = (int) 110_987_654_6299.123_34;
        float f = (long) l++ + 10 + ++x - (byte) m;//1234567000
        l =  (long) f / 1000;//1234567
        System.out.println(l);
    }
}