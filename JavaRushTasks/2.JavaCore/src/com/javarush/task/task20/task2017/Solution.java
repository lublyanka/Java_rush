package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        //почему не принимается,
        // Метод getOriginalObject должен возвращать null, если при попытке десериализации не был получен объект типа A.
        //Метод getOriginalObject должен возвращать null, если при попытке десериализации возникло исключение.
        /*try {
            A originalObject = (A)objectStream.readObject();
            return originalObject;
        }  catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e);
            //почему return null; не здесь
        }catch (IOException e) {
            System.out.println("IOException" + e);
        }
        return null;
        }*/
        try {
            return (Solution.A) objectStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
