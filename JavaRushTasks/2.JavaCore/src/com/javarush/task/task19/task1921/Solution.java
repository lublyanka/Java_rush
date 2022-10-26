package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDate;
import java.time.ZoneId;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while (reader.ready()){
                String currentRow = reader.readLine();
                String data[] = currentRow.split(" ");
                int dataLength = data.length;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date = null;
               /* StringBuilder stringBuilder = new StringBuilder();
                stringBuilder
                        .append(data[dataLength-1])
                        .append("/")
                        .append(data[dataLength-2])
                        .append("/")
                        .append(data[dataLength-3]);
                */


                //JR Data parse
                /*int year = Integer.parseInt(data[data.length - 1]);
                int month = Integer.parseInt(data[data.length - 2]) - 1; //January == 0.
                int day = Integer.parseInt(data[data.length - 3]);
                Calendar birthDay = new GregorianCalendar(year, month, day);*/
                //Иванов Иван Иванович 31 12 1987
                //Вася 15 5 2013

                //Добавили валидацию дней/месяцев через LocalDate + ZoneID
                //int year = Integer.parseInt(data[data.length - 1]);
                //int month = Integer.parseInt(data[data.length - 2]) ; //January == 0.
                //int day = Integer.parseInt(data[data.length - 3]);
                //Calendar birthDay = new GregorianCalendar(year, month, day);
                //date = Date.from(LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant());


                /*try {
                    date = simpleDateFormat.parse(stringBuilder.toString());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }*/
                String name;
                //StringBuffer можно было использовать
                StringBuilder stringBuilder2 = new StringBuilder();
                int nameLength = dataLength -3;
                for (int i =0; i < nameLength; i++)
                {
                    stringBuilder2.append(data[i] + " ");
                }
                name=stringBuilder2.toString().trim();
                PEOPLE.add(new Person(name, date));
                //PEOPLE.add(new Person(name, birthDay.getTime()));

            }
        }

        PEOPLE.forEach(x -> System.out.println(x.getName() + " " + x.getBirthDate()));

    }
}
