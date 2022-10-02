package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

public class SolutionMy {
    public static void main(String[] args) throws IOException {

        //getting the input List of filenames
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileRow;
        List<String> filenameParts = new ArrayList<String>();
        ;
        while (!(fileRow = reader.readLine()).equals("end")) {
            filenameParts.add(fileRow);
        }
        reader.close();

        //sorting the input List
        Collections.sort(filenameParts);

        //вычленяем имя папки и имя файла
        int pathFinalPosition = filenameParts.get(0).lastIndexOf(File.separator);
        int nameFinalPosition = filenameParts.get(0).lastIndexOf(".part");
        String filename = filenameParts.get(0).substring(pathFinalPosition + 1, nameFinalPosition);
        String path = filenameParts.get(0).substring(0, pathFinalPosition+1);

        File theWholeFile = new File(String.join("",path,filename));
        try (FileOutputStream outputStream = new FileOutputStream(theWholeFile)) {
                        for (String file : filenameParts
            ) {
                try (FileInputStream inputStream = new FileInputStream(file)) {
                    byte[] buffer = new byte[inputStream.available()];
                    while (inputStream.available() > 0) {
                        int bytesRead = inputStream.read(buffer);
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
        }

    }
}