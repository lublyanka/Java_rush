package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream instance;

    public QuestionFileOutputStream (AmigoOutputStream instance){
        this.instance = instance;
    }

    @Override
    public void flush() throws IOException {
        instance.flush();
    }

    @Override
    public void write(int b) throws IOException {
        instance.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        instance.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        instance.write(b,off,len);
    }

    @Override
    public void close() throws IOException {

            System.out.println("Вы действительно хотите закрыть поток? Д/Н");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            if(reader.readLine().equals("Д"))
            {
                //Thread.interrupted();
                //this.close();
                instance.close();
            }

    }
}

