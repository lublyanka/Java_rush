package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
        ;
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf,off,len);
        System.out.println(new String(cbuf).substring(off, off + len));
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println((char)c);
    }

    public void write(String str) throws IOException{
        fileWriter.write(str);
        System.out.println(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str,off,len);
        System.out.println(str.substring(off, off + len));

    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        for (char x: cbuf) {
            System.out.print(x);
        }
        System.out.println();
        //shorter
        // System.out.println(new String(cbuf));

    }

    public void close() throws IOException{
        this.fileWriter.close();
    }

    public static void main(String[] args) {

        try {
            FileConsoleWriter fileConsoleWriter= new FileConsoleWriter("d:\123.txt");
            char[] cbuf = {'1','2','3','4','5','6','7','8','9'};
            fileConsoleWriter.write(cbuf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
