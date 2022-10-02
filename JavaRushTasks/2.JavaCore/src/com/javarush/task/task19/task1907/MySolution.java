package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Считаем слово
*/

public class MySolution {
    public static void main(String[] args) throws IOException {

        String filename;
        AtomicInteger worldCounter= new AtomicInteger();
        String magicWord = "world";

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            filename = reader.readLine();
        }

        try(FileReader fileReader = new FileReader(filename)){
            String row;
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                if ((row=scanner.next()).contains(magicWord)) {
                    row = row.replaceAll("\\p{Punct}", " ");
                    Arrays.stream(row.split(" "))
                            .filter(x -> x.equals(magicWord))
                            .forEach(x -> worldCounter.getAndIncrement());
                    //вместо forEach можно было count() присвоить это и потом в worldCounter+
                }
            }
        }

        System.out.println(worldCounter);

    }
}