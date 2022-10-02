package com.javarush.task.task18.task1823;

import com.sun.xml.internal.ws.util.StreamUtils;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        ArrayList<String> filenames = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String row;
            while(!(row=reader.readLine()).equals("exit")){
                filenames.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        filenames.forEach(x -> new ReadThread(x).start());
    }

    public static class ReadThread extends Thread  {
        private InputStream inputStream;
        private String fileName;
        public ReadThread(String fileName) {
            try{
                inputStream = new FileInputStream(fileName);
                this.fileName = fileName;
            }
            catch (FileNotFoundException fileNotFoundException){

            }
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                if(inputStream!=null) {
                    int[] bytes = new int[256];
                    while (inputStream.available() > 0) {
                        bytes[inputStream.read()]++;
                    }

               /*     Integer maxKey = IntStream.range(0, bytes.length)
                            .mapToObj(x -> new AbstractMap.SimpleEntry<Integer, Integer>(x, bytes[x]))
                            .max(Comparator.comparing(AbstractMap.SimpleEntry::getValue))
                            .map(x -> x.getKey())
                            .get();*/


                    int maxCount = 0;
                    int maxCountByte = 0;
                    for (int i = 0; i < bytes.length; i++) {
                        if (bytes[i] > maxCount) {
                            maxCount = bytes[i];
                            maxCountByte = i;
                        }
                    }

                    //Arrays.stream(bytes).iterator().f;

                    synchronized (resultMap){
                    resultMap.put(this.fileName,maxCountByte);}

                    inputStream.close();
                }
            }
            catch (IOException e){
                e.getMessage();
            }
        }




    }
}
