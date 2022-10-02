package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Date newDate;

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dateString = reader.readLine();

        newDate = simpleDateFormat.parse(dateString);

        simpleDateFormat.applyPattern("MMM dd, yyyy");
        String date = simpleDateFormat.format(newDate);
        System.out.println(date.toUpperCase());
    }
}