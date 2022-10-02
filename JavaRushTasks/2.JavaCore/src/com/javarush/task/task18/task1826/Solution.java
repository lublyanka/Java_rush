package com.javarush.task.task18.task1826;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    private static final int secretSalt = 42;

    public static void main(String[] args) throws FileNotFoundException {
        if(args.length ==0 || args.length <3)
            try {
                throw new WrongNumberArgsException("3");
            } catch (WrongNumberArgsException e) {
                throw new RuntimeException(e);
            }

        try(FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2])){
            switch (args[0]){
                //encrypt
                case "-e": {
                    //encrypt(inputStream,outputStream);
                    while (inputStream.available() >0)
                    {
                        outputStream.write(inputStream.read()- secretSalt);
                    }
                }

                //decrypt
                case "-d": {
                    //decrypt(inputStream,outputStream);
                    while (inputStream.available() >0)
                    {
                        outputStream.write(inputStream.read()+ secretSalt);
                    }

                }

                default: throw new IllegalArgumentException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public synchronized static void decrypt (FileInputStream inputStream, FileOutputStream outputStream) throws IOException{
        while (inputStream.available() >0)
    {
        outputStream.write(inputStream.read()- secretSalt);
    }
        inputStream.close();
        outputStream.close();}

    public synchronized  static void encrypt (FileInputStream inputStream, FileOutputStream outputStream) throws IOException {
        while (inputStream.available() >0)
    {
        outputStream.write(inputStream.read()+ secretSalt);
    }
        inputStream.close();
        outputStream.close();}

}
