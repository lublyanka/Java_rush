package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/

public class Solution {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){

        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        //не работает с writeChars/writeInt не понимаю почему
//        public void writeExternal(ObjectOutput out) throws IOException {
//            out.writeChars(firstName);
//            out.writeChars(lastName);
//            out.writeInt(age);
//            out.writeObject(mother);
//            out.writeObject(father);
//            out.writeObject(children);
//        }

        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeUTF(firstName);
            out.writeUTF(lastName);
            out.writeInt(age);
            //mother.writeExternal(out);
            //father.writeExternal(out);

            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

//        public void writeExternal(ObjectOutput out) throws IOException {
//            out.writeObject(firstName);
//            out.writeObject(lastName);
//            out.writeObject(age);
//            out.writeObject(mother);
//            out.writeObject(father);
//            out.writeObject(children);
//        }

        @Override
        //не работает
        // Сервер не может корректно протестировать присланное решение.
        // Убедись в наличии всех необходимых классов. Проверь, что в решении нет бесконечных циклов.
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = in.readUTF();
            lastName = in.readUTF();
            age = in.readInt();
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            children = (List<Person>) in.readObject();
        }
//        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//            firstName = (String) in.readObject();
//            lastName = (String) in.readObject();
//            age = (int) in.readObject();
//            mother = (Person) in.readObject();
//            father = (Person) in.readObject();
//            children = (List<Person>) in.readObject();
//        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream inMemoryStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(inMemoryStream);

        Person root = new Person("name", "surname", 12);
        root.setFather(new Person("123", "456", 23));
        root.setMother(new Person("453", "3453465", 26));
        List<Person> children = new ArrayList<>();
        children.add(new Person("fghfghjh", "dsfvdfbfdg", 324) );
        root.setChildren(children);

        root.writeExternal(objectOutputStream);

        objectOutputStream.close();
        inMemoryStream.flush();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inMemoryStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);

        Person newRoot = new Person();
        newRoot.readExternal(ois);

    //    System.out.println(newRoot);
    }
}
