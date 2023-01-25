package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password);
    }

    public static ByteArrayOutputStream getPassword() {
        char[] digits = "0123456789".toCharArray();
        char[] abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] source = (String.valueOf(digits) + String.valueOf(abc)).toCharArray();
        char[] pass = new char[8];

        String prepass = new String(pass);
        while (!isValid(prepass))
            prepass = fillPassword(source, pass);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new String(pass).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return byteArrayOutputStream;
    }

    private static String fillPassword(char[] source, char[] pass) {
        for (int i = 0; i < pass.length; i++) {
            pass[i] = source[(int) Math.round((Math.random() * (source.length - 1)))];
        }
        return new String(pass);
    }

    private static boolean isValid(String prepass) {
        return prepass.matches(".*\\d.*+")
                && prepass.matches(".*[a-z].*+")
                && prepass.matches(".*[A-Z].*+");
    }

}
