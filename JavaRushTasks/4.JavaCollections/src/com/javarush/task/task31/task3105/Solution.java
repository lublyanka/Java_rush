package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        List<Content> entries = getContents(args[1]);

        ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(Paths.get(args[1])));

        Path file = Paths.get(args[0]);
        zipOutputStream.putNextEntry(new ZipEntry("new/" + file.getFileName().toString()));

        Files.copy(file, zipOutputStream);

        for (Content content : entries) {
            if (!content.fileName.equals("new/" + file.getFileName().toString())) content.writeToZip(zipOutputStream);
        }

        zipOutputStream.close();
    }

    private static ArrayList<Content> getContents(String arg) throws IOException {
        ArrayList<Content> entries = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(Paths.get(arg)))) {
            ZipEntry currentEntry;
            byte[] buffer = new byte[1024];
            while ((currentEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int length;
                while ((length = zipInputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                entries.add(new Content(currentEntry.getName(), outputStream.toByteArray()));
            }
        }
        return entries;
    }

    static class Content {
        String fileName;
        byte[] body;

        Content(String fileName, byte[] body) {
            this.fileName = fileName;
            this.body = body;
        }

        void writeToZip(ZipOutputStream zip) throws IOException {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zip.putNextEntry(zipEntry);
            zip.write(body);
            zip.closeEntry();
        }
    }
}