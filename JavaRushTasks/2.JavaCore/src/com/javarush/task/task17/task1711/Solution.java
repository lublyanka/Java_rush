package com.javarush.task.task17.task1711;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    private static List<String> arguments ;
    static String pattern = "dd-MMM-yyyy";
    static SimpleDateFormat  simpleDateFormat = new SimpleDateFormat(pattern);



    public static void main(String[] args) {

        try {
            if (args == null || args.length < 1) {
                System.out.println("Число входных параметров не соответствует режиму или равно 0");
                throw new WrongNumberArgsException("");

            }

        arguments=  Arrays.asList(args);

            try {
                switch (args[0]) {

                    case "-c": {

                        synchronized (allPeople) {
                            if ((arguments.size() - 1) % 3 != 0) {
                                throw new WrongNumberArgsException("");
                            }
                            createMode();
                        }
                        break;
                    }

                    case "-u": {

                        synchronized (allPeople) {
                            if ((arguments.size() - 1) % 4 != 0) {
                                throw new WrongNumberArgsException("");
                            }
                            updateMode();
                        }
                        break;
                    }

                    case "-d": {

                        synchronized (allPeople) {
                            if (arguments.size() < 2) {
                                throw new WrongNumberArgsException("");
                            }
                            deleteMode();
                        }
                        break;
                    }

                    case "-i": {

                        synchronized (allPeople) {
                            if (arguments.size() < 2) {
                                throw new WrongNumberArgsException("");
                            }
                            infoMode();
                        }
                        break;
                    }

                    //: {
                      //  throw new IllegalArgumentException();
                    //}
                }
            }catch (Exception e){}
        }
        catch (WrongNumberArgsException e) {
            throw new RuntimeException(e);
        }


    }

    // Create mode
    private static void createMode() {
        String id = "";
        try {
            for (int i = 1; i < arguments.size(); i=i+3) {

                Person personToAdd=null;

                String name = arguments.get(i);;
                Sex sex=null;
                Date birthDate;

                birthDate=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(arguments.get(i+2));


                switch (arguments.get(i+1))
                {
                    case "м":{sex=Sex.MALE; personToAdd = Person.createMale(name,birthDate); break;}

                    case "ж":{sex=Sex.FEMALE; personToAdd = Person.createFemale(name,birthDate);break;}
                }

                if(personToAdd!=null)
                    allPeople.add(personToAdd);

                System.out.println(allPeople.indexOf(personToAdd));

            }
        } catch (IllegalArgumentException ie)        {
            System.out.println("Неправильный параметр пола");
        }
        catch (ParseException e) {
            System.out.println("Неправильный формат параметры даты для DD/MM/YYYY");
            throw new RuntimeException(e);
        }

    }

    // Delete mode
    private static void deleteMode() {
        String id="";

        try {
            {
                for (int i = 1; i < arguments.size(); i++) {
                    id = arguments.get(i);

                    Person personToDelete = allPeople.get(Integer.parseInt(id));

                    if (personToDelete == null) {

                        throw new ArrayIndexOutOfBoundsException();
                    }

                    personToDelete.setName(null);
                    personToDelete.setSex(null);
                    personToDelete.setBirthDate(null);

                    System.out.println(id + " "
                            + personToDelete.getName() + " "
                            + personToDelete.getSexToString() + " "
                            + personToDelete.getBirthDate());
                }
            }
        } catch (NumberFormatException n) {
            System.out.println("Неверный формат id персоны" + id);
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Не существует персоны с таким id" + id);
        }

    }

    // Info readonly mode
    private static void infoMode() {

        String id = "";
        try {
            {
                for (int i = 1; i < arguments.size(); i++) {
                    id = arguments.get(i);
                    Person personToShow = allPeople.get(Integer.parseInt(id));
                    if (personToShow == null) {
                        throw new ArrayIndexOutOfBoundsException();
                    }

                    System.out.println(personToShow.getName() + " "
                            + personToShow.getSexToString() + " "
                            + simpleDateFormat.format(personToShow.getBirthDate()));
                }
            }
        } catch (NumberFormatException n) {
            System.out.println("Неверный формат id персоны " + id);
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Не существует персоны с таким id " + id);
        }
    }

    // Update mode
    private static void updateMode(){
        String id = "";
        try {
                for (int i = 1; i < arguments.size(); i=i+4) {
                    id = arguments.get(i);

                    Person personToUpdate = allPeople.get(Integer.parseInt(id));

                    if (personToUpdate == null) {
                        throw new ArrayIndexOutOfBoundsException();
                    }

                    String name = arguments.get(i+1);
                    Sex sex=null;;
                    Date birthDate;

                    switch (arguments.get(i+2))
                    {
                        case "м":{sex=Sex.MALE; break;}

                        case "ж":{sex=Sex.FEMALE;break;}
                    }

                    birthDate=new SimpleDateFormat("dd/MM/yyyy").parse(arguments.get(i+3));

                    personToUpdate.setName(name);
                    personToUpdate.setSex(sex);
                    personToUpdate.setBirthDate(birthDate);

                    System.out.println(personToUpdate.getName() + " "
                            + personToUpdate.getSexToString() + " "
                            + simpleDateFormat.format(personToUpdate.getBirthDate()));

                }
        } catch (NumberFormatException n) {
            System.out.println("Неверный формат id персоны " + id);
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Не существует персоны с таким id " + id);
        }catch (ParseException e) {
            System.out.println("Неправильный формат параметры даты для DD/MM/YYYY");
            throw new RuntimeException(e);
        }

    }

}
