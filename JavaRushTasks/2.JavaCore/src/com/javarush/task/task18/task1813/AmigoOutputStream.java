package com.javarush.task.task18.task1813;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{

    private FileOutputStream fileOutputStream;


    public static String fileName = "C:/tmp/result.txt";
    private static String javaRow = "JavaRush © All rights reserved.";

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        flush();
        fileOutputStream.write(javaRow.getBytes());
        fileOutputStream.close();
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    public AmigoOutputStream(File file) throws FileNotFoundException {
        super(file);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));

    }
}
