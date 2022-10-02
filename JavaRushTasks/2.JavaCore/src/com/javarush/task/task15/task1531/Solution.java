package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
*/

public class Solution {

    private static BigDecimal  result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = null;

        try {
            while ((key = reader.readLine()) != null) {
                int input =0;
                if (Integer.parseInt(key) <= 150)
                    input = Integer.parseInt(key);
                reader.close();
                System.out.println(factorial(input));
            }
        }
        catch (IOException e)
        {}

        //int input = Integer.parseInt(reader.readLine());
        //reader.close();


    }

    public static String factorial(int n) {
        if(n <0)
            return "0";
        result = BigDecimal.valueOf(1);

        for (int i = 1; i <= n ; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        System.out.println(String.valueOf(result));
        System.out.println(String.format("%,.0f",result));
        return String.valueOf(result);//String.format("%,.0f",result);

    }
}
