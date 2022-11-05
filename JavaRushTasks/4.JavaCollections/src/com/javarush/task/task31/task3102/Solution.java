package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


import static java.nio.file.FileVisitOption.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        ArrayList<String> result = new ArrayList<>();
        EnumSet<FileVisitOption> options = EnumSet.of(FOLLOW_LINKS) ;


        Files.walkFileTree(Paths.get(root), options, 50, new Visitor(result));
        return result;


    }

    private static class Visitor extends SimpleFileVisitor<Path> {
        ArrayList<String> result;

        public Visitor(ArrayList<String> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            File file = path.toFile();
            if (file.isFile()) {
                    result.add(path.toAbsolutePath().toString());
            }
            return super.visitFile(path, attrs);
        }

    }

    public static void main(String[] args) {

    }
}
