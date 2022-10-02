package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        ArrayList<String> persons = new ArrayList<>();

        try {
            while(Categories.hasValue(key = reader.readLine())) {
                persons.add(key);
            }

            /*while (Arrays.stream(Categories.values())
                    .map(c -> c.getTitle())
                    .reduce(key = reader.readLine(), (k, val) -> k == val ? null : k) == null)
            {
                persons.add(key);
            }*/

//            while (Arrays.stream(Categories.values()).map(xTitle -> {
//                try {
//                    return key=reader.readLine().toLowerCase().equals(xTitle.getTitle());
//                } catch (IOException e) {
//                    return false;
//                }
//            }))
//            {
//                persons.add(key);
//            };
        }
        catch (IOException e)
        {}

        {
            persons.remove("/n");persons.remove("/r/n");persons.remove("");
            persons.forEach(man -> {
                //Categories category = Arrays.stream(Categories.values()).filter(cat -> cat.getTitle().equals(man)).findFirst().get();
                //switch (category)
                switch (Categories.getNameFromString(man))
                {
                    case CODER: {doWork(new Person.Coder());break;}
                    case LOSER: {doWork(new Person.Loser());break;}
                    case PROGER: {doWork(new Person.Proger());break;}
                    case USER: {doWork( new Person.User());break;}
                }
            });

            //doWork(person); //вызываем doWork

        }
    }

    /*public class Lambda {
        final String key;
        final BufferedReader reader;

        public Lambda(String key, BufferedReader reader) {
            this.key = key;
            this.reader = reader;
        }


        public boolean invoke(Categories xTitle)  {
            try {
                return key=reader.readLine().toLowerCase().equals(xTitle.getTitle());
            } catch (IOException e) {
                return false;
            }
        }
    }*/

    public static void doWork(Person person) {
        if (person instanceof Person.User)
            ((Person.User) person).live();
        if(person instanceof Person.Loser)
        { ((Person.Loser) person).doNothing();}
        if(person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        }
        if(person instanceof Person.Proger){
            ((Person.Proger) person).enjoy();
        }

    }
}
