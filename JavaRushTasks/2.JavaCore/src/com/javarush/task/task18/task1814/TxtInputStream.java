package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    private FileInputStream fileInputStream;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        //это не совсем правильное решение так как дважды вызов FileInputStream в super и new
        /*if(fileName.endsWith(".txt")) {
            this.fileInputStream = new FileInputStream(fileName);}
        else
            {super.close();
            throw new UnsupportedFileNameException();}*/

        if (!fileName.endsWith(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();}
    }

    public static void main(String[] args) {
    }
}

