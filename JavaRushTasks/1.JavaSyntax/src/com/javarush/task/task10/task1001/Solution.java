package com.javarush.task.task10.task1001;

/* 
Задача №1 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0;
        int b = (byte) a + 46;
        byte c = (byte) (a * b);
        double f = (char) 1234.15;
        long f12 = (int) Double.POSITIVE_INFINITY;
        String sResult = Long.toBinaryString(Double.doubleToLongBits(Double.POSITIVE_INFINITY));
        String sResult12 = Long.toBinaryString((long) Double.POSITIVE_INFINITY);
        long l2 = 0x7ff0000000000000L;
        long l3 = (long) Double.POSITIVE_INFINITY;
        String sResult123 = Long.toBinaryString(l2);
        String sResult124 = Long.toBinaryString(l3);
        String sResult2 = Long.toBinaryString((long) ( f/c));
        String sResult3 = Integer.toBinaryString((short) ( f/c));
        String sResult4 = Integer.toBinaryString((short) ( f/c+1));
        int c5 = 10000;
        String sResultC5 = Integer.toBinaryString(c5);
        byte d5 = (byte) c5;
        //byte numberBitsD5 = Byte.parseByte(Integer.toBinaryString(d5));
        String sResultD5 = Integer.toBinaryString(d5);
        long fc = (short) ( f/c + a);
        long d = (long) (a + f / c + b);
        System.out.println(d);
    }
}
