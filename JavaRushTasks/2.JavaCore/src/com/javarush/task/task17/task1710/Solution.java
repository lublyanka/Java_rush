package com.javarush.task.task17.task1710;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static List<String> arguments ;
    static String pattern = "dd-MMM-yyyy";
    static SimpleDateFormat  simpleDateFormat = new SimpleDateFormat(pattern);



    public static void main(String[] args) {

        if (args == null || args.length < 1) {
                System.out.println("Число входных параметров не соответствует режиму или равно 0");
                throw new RuntimeException();
        }

        arguments=  Arrays.asList(args);
        try {
            switch (args[0])
            {
                case "-c": {
                    if(arguments.size() < 4){
                    throw new WrongNumberArgsException("");
                }
                createMode(); break;}

                case "-r": {
                    if(arguments.size() < 2){
                    throw new WrongNumberArgsException("");
                }
                readMode(); break;}

                case "-u": {
                    if(arguments.size() < 5) {
                        throw new WrongNumberArgsException("");
                    }
                    updateMode();break;}

                case "-d": {
                    if(arguments.size() < 2){
                        throw new WrongNumberArgsException("");
                    }
                    deleteMode();break;}

                default: {throw new IllegalArgumentException();}
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Забыли указать входные параметры");
        }
        catch (WrongNumberArgsException e){
            System.out.println("Число входных параметров не соответствует режиму");
        }
    }

    private static void createMode() {
        try {
            {
                Person personToAdd=null;
                String name = arguments.get(1);;
                Sex sex=null;
                Date birthDate;

                birthDate=new SimpleDateFormat("dd/MM/yyyy").parse(arguments.get(3));


                switch (arguments.get(2))
                {
                    case "м":{sex=Sex.MALE; personToAdd = Person.createMale(name,birthDate); break;}

                    case "ж":{sex=Sex.FEMALE; personToAdd = Person.createFemale(name,birthDate);break;}
                }

                allPeople.add(personToAdd);
                //Person personToShow=allPeople.get(allPeople.indexOf(personToAdd));

                System.out.println(allPeople.indexOf(personToAdd));
                /*System.out.println(personToShow.getName() + " "
                        + (personToShow.getSex()==Sex.MALE ? "м" : (personToShow.getSex()==Sex.FEMALE ? "ж": null)) + " "
                        + simpleDateFormat.format(personToShow.getBirthDate()));*/
            }
        }
        catch (IllegalArgumentException ie)        {
            System.out.println("Неправильный параметр пола");
        } catch (ParseException e) {
            System.out.println("Неправильный формат параметры даты для DD/MM/YYYY");
            throw new RuntimeException(e);
        }
    }

    private static void readMode(){

        try {
            {
                Person personToShow = allPeople.get(Integer.parseInt(arguments.get(1)));

                System.out.println(personToShow.getName() + " "
                        + (personToShow.getSex()==Sex.MALE ? "м" : (personToShow.getSex()==Sex.FEMALE ? "ж": null)) + " "
                        + simpleDateFormat.format(personToShow.getBirthDate()));
            }
        }

        catch (NumberFormatException n)
        {
            System.out.println("Неверный формат id персоны");
        }
        catch (ArrayIndexOutOfBoundsException a)
        {
            System.out.println("Не существует персоны с таким id" + arguments.get(1));
        }

    }

    private static void updateMode(){
        try {
            {
                int inX = Integer.parseInt(arguments.get(1));
                String name = arguments.get(2);;
                Sex sex=null;
                Date birthDate;

                birthDate=new SimpleDateFormat("dd/MM/yyyy").parse(arguments.get(4));

                switch (arguments.get(3))
                {
                    case "м":{sex=Sex.MALE; break;}

                    case "ж":{sex=Sex.FEMALE;break;}
                }

                allPeople.get(inX).setName(name);
                allPeople.get(inX).setSex(sex);
                allPeople.get(inX).setBirthDate(birthDate);

                Person personToShow = allPeople.get(inX);

                System.out.println(personToShow.getName() + " "
                        + (personToShow.getSex()==Sex.MALE ? "м" : (personToShow.getSex()==Sex.FEMALE ? "ж": null)) + " "
                        + simpleDateFormat.format(personToShow.getBirthDate()));
            }
        }
        catch (NumberFormatException n)
        {
            System.out.println("Неверный формат id персоны");
        }
        catch (ArrayIndexOutOfBoundsException a)
        {
            System.out.println("Не существует персоны с таким id" + arguments.get(1));
        } catch (ParseException e) {
            System.out.println("Неправильный формат параметры даты для DD/MM/YYYY");
            throw new RuntimeException(e);
        }

    }

    private static void deleteMode(){
        try {
            {
                Person personToDelete = allPeople.get(Integer.parseInt(arguments.get(1)));
                personToDelete.setName(null);
                personToDelete.setSex(null);
                personToDelete.setBirthDate(null);
                System.out.println(personToDelete.getName() + " "
                        + (personToDelete.getSex()==Sex.MALE ? "м" : (personToDelete.getSex()==Sex.FEMALE ? "ж": null) + " "
                        + personToDelete.getBirthDate()));

            }
        }
        catch (NumberFormatException n)
        {
            System.out.println("Неверный формат id персоны");
        }
        catch (ArrayIndexOutOfBoundsException a)
        {
            System.out.println("Не существует персоны с таким id" + arguments.get(1));
        }

    }
}
