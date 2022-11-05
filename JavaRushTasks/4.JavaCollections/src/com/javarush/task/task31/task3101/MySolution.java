package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class MySolution {
    public static void main(String[] args) throws IOException {
        String newName = "/allFilesContent.txt";
        //directory Path

        if (args.length > 0) {
            Path path = Paths.get(args[0]);

            //full path to file with result
            Path resultFilePath = Paths.get(args[1]);
            File resultFile = resultFilePath.toFile();
            File dest = new File(resultFile.getParentFile() + newName);

            //rename result file or create if nor exists


            if (FileUtils.isExist(dest)) {
                FileUtils.deleteFile(dest);
            }
            FileUtils.renameFile(resultFile, dest);

            //FileUtils.renameFile(resultFile, new File(resultFile.getParentFile() + newName));
            /*File newFile = new File(resultFileAbsolutePath.getParent() + newName);
            newFile.createNewFile();
            resultFileAbsolutePath = newFile;*/

            //write content to the result file
            try (FileOutputStream writer = new FileOutputStream(resultFile)) {

                File[] arrFiles = path.toFile().listFiles();
                ArrayList<File> fileList = new ArrayList<File>();
                fileAdder(arrFiles,fileList);

                for (File file: fileList) {
                    if(Files.size(file.toPath()) < 50){
                        try(BufferedReader reader = new BufferedReader( new FileReader(file))){
                            while (reader.ready()){
                                writer.write(reader.readLine().getBytes(StandardCharsets.UTF_8));
                                writer.write("\n".getBytes(StandardCharsets.UTF_8));
                            }
                            writer.write("\n".getBytes(StandardCharsets.UTF_8));
                        }
                    }
                }
            }
        }
    }

    private static void fileAdder(File[] arrFiles, ArrayList<File> fileList) {
        for (File file:arrFiles) {
            if(file.isFile())
                fileList.add(file);
            if(file.isDirectory()){
                fileAdder(file.listFiles(),fileList);
            }
        }
    }
}