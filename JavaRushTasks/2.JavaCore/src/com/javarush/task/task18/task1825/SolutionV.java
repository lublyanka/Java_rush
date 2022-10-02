package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.ArrayList;

public class SolutionV {
        public static void main(String[] args) throws IOException {

            //getting the input List of filenames
            ArrayList<String> files = new ArrayList<String>();
            try (InputStreamReader console = new InputStreamReader(System.in)) {
                try(BufferedReader reader = new BufferedReader(console))
                {
                    String file;
                    while(!(file = reader.readLine()).equals("end"))
                    {
                        files.add(file);
                    }
                }
            }

            //sorting the input List
            files.sort((path1, path2) -> {
                int index1 = path1.lastIndexOf(".part");
                int index2 = path2.lastIndexOf(".part");
                Integer part1 = Integer.parseInt(path1.substring(index1 + 5));
                Integer part2 = Integer.parseInt(path2.substring(index2 + 5));
                return part1.compareTo(part2);
            });

            String path1 = files.get(0);
            String index1 = String.valueOf(path1.lastIndexOf(".part"));
            String outputPath = path1.substring(0, Integer.parseInt(index1));

            try(FileOutputStream outputStream = new FileOutputStream(outputPath)) {
                try (java.nio.channels.FileChannel output = outputStream.getChannel()) {
                    for (String file : files) {
                        try (FileInputStream inputStream = new FileInputStream(file)) {
                            try(java.nio.channels.FileChannel input = inputStream.getChannel())
                            {
                                long lastPosition = 0L;
                                long transferred = 0L;
                                while((transferred = input.transferTo(lastPosition, Integer.MAX_VALUE, output)) > 0){
                                    lastPosition += transferred;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
