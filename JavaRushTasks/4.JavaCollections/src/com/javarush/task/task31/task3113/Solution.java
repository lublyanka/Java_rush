package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {
    private String dirname;
    private static AtomicInteger dircount = new AtomicInteger();
    private static AtomicInteger filecount = new AtomicInteger();
    private static AtomicLong size = new AtomicLong();
    static Path root;


    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        solution.dirname = reader.readLine();


        root = Paths.get(solution.dirname);
        if (!Files.isDirectory(root))
            System.out.println(root.toString() + " - не папка");
        else {
            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    if (!dir.equals(root))
                        dircount.incrementAndGet();

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    filecount.incrementAndGet();
                    size.addAndGet(attrs.size());

                    return FileVisitResult.CONTINUE;
                }
            })

            ;
            printresult(solution);
        }
/*
        File dir = new File(solution.dirname);

        File[] fileList = dir.listFiles();

        if (fileList == null)
            System.out.println(dir.getAbsolutePath() + " - не папка");
        if (fileList != null) {
            getFileTree(solution, fileList);

        printresult(solution);*/
    }

    private static void printresult(Solution solution) {
        StringBuilder sb = new StringBuilder();
        sb.append("Всего папок - ").append(solution.dircount).append("\n");
        sb.append("Всего файлов - " + solution.filecount + "\n");
        sb.append("Общий размер - " + solution.size);

        System.out.println(sb);
    }

   /* private static void getFileTree(Solution solution, File[] fileList) {
        for (File file : fileList) {
            if (file.isDirectory()) {
                solution.dircount.addAndGet(1);
                File[] subdirtree = file.listFiles();
                if (subdirtree != null)
                    getFileTree(solution, subdirtree);
            }
            solution.filecount.addAndGet(1);
            if (file.isFile())
                solution.size.addAndGet(file.length());
        }
    }*/
}
