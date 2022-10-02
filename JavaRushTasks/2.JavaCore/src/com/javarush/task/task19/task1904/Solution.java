package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        /*Path path = Paths.get("D:\\people.txt");
        Scanner scanner = new Scanner(path);
        PersonScanner personScannerAdapter = new PersonScannerAdapter(scanner);
        System.out.println(personScannerAdapter.read());
        System.out.println(personScannerAdapter.read());
        personScannerAdapter.close();*/
    }

    public static class PersonScannerAdapter implements PersonScanner  {
        private Scanner fileScanner ;


        public PersonScannerAdapter(Scanner scanner) {
             this.fileScanner = scanner;

        }
        @Override
        public Person read() throws ParseException {
            String[] personData;
            Date birthDate;

            personData=fileScanner.nextLine().split(" ");

            birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(String.join("/", personData[3], personData[4], personData[5]));

            /*//решение из JR
            Calendar calendar = new GregorianCalendar(Integer.parseInt(personData[5]), Integer.parseInt(personData[4]) - 1, Integer.parseInt(personData[3]));
            Date date = calendar.getTime();*/

            return new Person(personData[1],
                    personData[2],
                    personData[0],
                    birthDate);
        }

        @Override
        public void close() {
            fileScanner.close();
        }

    }
}
