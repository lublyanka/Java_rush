package com.javarush.task.task11.task1123;

public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};
        //int[] data = new int[]{-1, -2, -3, -5, -2, -8, -10, -128, -256, -1000};

        Pair result = getMinimumMaximumPair(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair getMinimumMaximumPair(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new Pair(null, null);
        }
        int minX=inputArray[0];
        int maxY=inputArray[0];

        for (int i = 0; i < inputArray.length; i++) {
            if (minX > inputArray[i])
            {minX = inputArray[i];}
            if (maxY < inputArray[i])
            {maxY = inputArray[i];
            }
        }
        return new Pair(minX, maxY);
    }

    public static class Pair {
        public Integer x;
        public Integer y;

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }
}
