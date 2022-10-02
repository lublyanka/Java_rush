package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String,Cat> mapCat = new HashMap<String, Cat>();
        mapCat.put("Пушок",new Cat("Пушок"));
        mapCat.put("Черныш",new Cat("Черныш"));
        mapCat.put("Лапочка",new Cat("Лапочка"));
        mapCat.put("Рыж",new Cat("Рыж"));
        mapCat.put("Копош",new Cat("Копош"));
        mapCat.put("Клоп",new Cat("Клоп"));
        mapCat.put("Арбалет",new Cat("Арбалет"));
        mapCat.put("Ворчун",new Cat("Ворчун"));
        mapCat.put("Гара",new Cat("Гара"));
        mapCat.put("Кики",new Cat("Кики"));
        return mapCat;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
      Set<Cat> catSet = new HashSet<>();
        for (Cat cat:map.values()) {
            catSet.add(cat);
        }
      return catSet;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
