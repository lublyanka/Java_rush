package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename="";

        while(true){
            try {filename = reader.readLine();
                try(FileInputStream inputStream= new FileInputStream(filename)){
                }
                catch (FileNotFoundException fileNotFoundException){
                    System.out.println(filename);
                    break;
            }
            }
            catch (IOException ioException){

            }
        }
    }
}
