package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        String filename1, filename2;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            filename1 = reader.readLine();
            filename2 = reader.readLine();
        }

        try (BufferedReader filereader1 = new BufferedReader(new FileReader(filename1));
             BufferedReader filereader2 = new BufferedReader(new FileReader(filename2))){

            //read all lines from file2
            List<String> file2Lines = new ArrayList<String>();
            List<String> file1Lines = new ArrayList<String>();
            while (filereader2.ready()){
                file2Lines.add(filereader2.readLine());
            }

            while(filereader1.ready()){
                file1Lines.add(filereader1.readLine());
            }
            int y = 0;
            int ySize = file2Lines.size();
            for (int i = 0; i < file1Lines.size(); i++) {
            try{
                String originalLine = file1Lines.get(i);
                if(originalLine.equals(file2Lines.get(y))){
                    LineItem lineItem = new LineItem(Type.SAME, originalLine);
                    lines.add(lineItem);
                    y++;
                }
                else if(originalLine.equals(file2Lines.get(y+1))) {
                    LineItem lineItem = new LineItem(Type.ADDED, file2Lines.get(y));
                    lines.add(lineItem);
                    lineItem = new LineItem(Type.SAME, originalLine);
                    lines.add(lineItem);
                    y+=2;
                }
                else
                {
                    LineItem lineItem = new LineItem(Type.REMOVED, originalLine);
                    lines.add(lineItem);
                }
            }
            catch (IndexOutOfBoundsException e){

            }

            }

            while (y < ySize) {
                LineItem lineItem = new LineItem(Type.ADDED, file2Lines.get(y));
                lines.add(lineItem);
                y++;
            }

            lines.forEach(x -> System.out.println(x.type + " "  + x.line));

            //JR
            /*while ((oldFileLine < oldFileLines.size()) && (newFileLine < newFileLines.size())) {

            if (oldFileLines.get(oldFileLine).equals(newFileLines.get(newFileLine))) {
                lines.add(new LineItem(Type.SAME, oldFileLines.get(oldFileLine)));
                oldFileLine++;
                newFileLine++;
            } else if ((newFileLine + 1 < newFileLines.size()) && oldFileLines.get(oldFileLine).equals(newFileLines.get(newFileLine + 1))) {
                lines.add(new LineItem(Type.ADDED, newFileLines.get(newFileLine)));
                newFileLine++;
            } else if ((oldFileLine + 1 < oldFileLines.size()) && oldFileLines.get(oldFileLine + 1).equals(newFileLines.get(newFileLine))) {
                lines.add(new LineItem(Type.REMOVED, oldFileLines.get(oldFileLine)));
                oldFileLine++;
            }
        }

        while (oldFileLine < (oldFileLines.size())) {
            lines.add(new LineItem(Type.REMOVED, oldFileLines.get(oldFileLine)));
            oldFileLine++;
        }
        while (newFileLine < (newFileLines.size())) {
            lines.add(new LineItem(Type.ADDED, newFileLines.get(newFileLine)));
            newFileLine++;
        }*/
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
