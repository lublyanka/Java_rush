package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4)); //это не нужно для проверки

        //Pattern для проверки сериализации
        //1) создать временный файл массив, открыть поток на чтение (input stream) и на запись(output stream);
        File your_file_name = File.createTempFile("your_file_name", null);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(your_file_name));
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(your_file_name));


        //2) создать экземпляр класса Solution - savedObject;
        Solution savedObject = new Solution(12);

        //3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
        outputStream.writeObject(savedObject);
        //savedObject.writeObject(outputStream); //вообще все падает
        outputStream.flush();

        //4) создать другой экземпляр класса Solution с другим параметром;
        Solution loadedObject = (Solution) inputStream.readObject();
        //не понимаю в чем разница с loadedObject.readObject(inputStream); и аналогчной перестановки на запись

        //5) загрузить из потока на чтение объект - loadedObject;
        outputStream.close();
        inputStream.close();

        //6) проверить, что  равна ;
        System.out.println(savedObject.string.equals(loadedObject.string));

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE"; //почему transient
    transient private Date currentDate;
    transient private int temperature; //почему transient
    String string; //почему не transient
    //почему не делаем пустой конструктор,?

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    // этого нет в решении
    /*
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
       in.defaultReadObject();


       this.currentDate = new Date();
       string = "Today is %s, and the current temperature is %s C";
       SimpleDateFormat format = new SimpleDateFormat(pattern);
       this.string = String.format(string, format.format(currentDate), temperature);
    }*/
}
