package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        String s = "cartoon";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       /* String finalS = s;

            do {
            s = reader.readLine();
            try{
            Movie movie = MovieFactory.getMovie(s);
            if(movie != null)
             System.out.println(movie.getClass().getSimpleName());}
            catch (Exception e) {
            }
            finally {
                break;
            }
            }
            while (Arrays.stream(MoviesList.values()).map(y->y.getTitle()).anyMatch(x -> x.toString().equals(finalS)));
        reader.close();
        }*/

        String key = null;
        while ((key = reader.readLine()) != null) {
            Movie movie = MovieFactory.getMovie(key);
            if (movie == null) {
                return;
            }
            System.out.println(movie.getClass().getSimpleName());
        }
        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран
        */
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            if (MoviesList.CARTOON.getTitle().equals(key)) {
                movie = new Cartoon();
            }

            if (MoviesList.THRILLER.getTitle().equals(key)) {
                movie = new Thriller();
            }

                return movie;
            }
        }

    enum MoviesList{
        CARTOON ("cartoon"),
        THRILLER("thriller"),
        SOAPOPERA ("soapOpera");

        private String title;
        MoviesList(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie{

    }
    static class Thriller extends Movie {


    }
}
