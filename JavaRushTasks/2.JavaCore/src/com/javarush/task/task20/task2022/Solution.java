package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true); //нафига true ????
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Solution)
            return equals((Solution) other);
        else return false;
    }

    public boolean equals(Solution other) {
        if (other == null)
            return false;
        return this.fileName.equals(other.fileName)
                && (this.stream != null) == (other.stream != null);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Solution original = new Solution("your_file_name.txt");
        original.writeObject("Новая строка");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("your_file_name_2.txt"));
        out.writeObject(original);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("your_file_name_2.txt"));
        Solution restore = (Solution) in.readObject();
        System.out.println(original.equals(restore)); //каааак?!?!

        
    }
}
