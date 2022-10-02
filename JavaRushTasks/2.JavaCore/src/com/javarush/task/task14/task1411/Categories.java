package com.javarush.task.task14.task1411;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public enum Categories {

    USER ("user"),
    LOSER("loser"),
    CODER("coder"),
    PROGER("proger");

    private Categories(String title) {
        this.title = title;
    }

    String title;

    public String getTitle(){
        return this.title;
    }

    public static Categories getNameFromString (String text)
    {
        for (Categories c: Categories.values()) {
            if(c.getTitle().equals(text))
                return c;
        }
        return null;
    };

    public static boolean hasValue(String value) {
        return allowedValues.contains(value);
    }

    private final static Set<String> allowedValues;

    static {
        allowedValues = new HashSet<String>();
        for (Categories value : Categories.values()) {
            allowedValues.add(value.getTitle());
        }
    }

}
