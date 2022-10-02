package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            BufferedWriter writer= new BufferedWriter(new FileWriter(reader.readLine()));
            Scanner scanner = new Scanner(System.in);
            String line;
            do{
                line = scanner.nextLine();

                writer.write(line);
                writer.newLine();
            }
            while (!line.equalsIgnoreCase("exit")) ;
            reader.close();
            writer.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}



    }
}
