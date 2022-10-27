package com.javarush.task.task20.task2020;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.Logger;

/* 
Сериализация человека
*/

public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName; //почему transient - потому что собираем из lastName, firstName в производную строку
        transient final String greeting; //почему transient - потому что нет обращений извне, кроме конструктора, фактически константа
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(){
            this.greeting = "Hello, "; //может не надо было это писать? почему не перенести его сразу к объявлению
            //у JR вообще нет этого пустого конструктора, хотя ведь надо же?
        }

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {

    }
}
