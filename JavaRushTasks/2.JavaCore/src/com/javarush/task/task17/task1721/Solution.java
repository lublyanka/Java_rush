package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String filename1 = "", filename2 = "";

        //get filenames
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            filename1 = reader.readLine();
            filename2 = reader.readLine();
        } catch (IOException e) {
        }

        try (BufferedReader reader1 = new BufferedReader(new FileReader(filename1));
             BufferedReader reader2 = new BufferedReader(new FileReader(filename2));) {
            while (reader1.ready()) {
                allLines.add(reader1.readLine());
            }

            while (reader2.ready()) {
                forRemoveLines.add(reader2.readLine());
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException e) {
        }

        try {Solution solution = new Solution();
            solution.joinData();}
        catch (CorruptedDataException corruptedDataException){
            System.out.println(corruptedDataException.getMessage());
        }
    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);}
        else {
            allLines.clear();
            throw  new CorruptedDataException();
        }
    }
}
