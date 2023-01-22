package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private List<Path> foundFiles = new ArrayList<>();
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        /*if (!containPartOfName(file)
                || !isBiggerThanMinSize(content)
                || !isSmallerThanMaxSize(content)
                || !contentContain(content))
            return FileVisitResult.CONTINUE;
        else
        foundFiles.add(file);
        return super.visitFile(file, attrs);*/

        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) return FileVisitResult.CONTINUE;

        if ((maxSize > 0 && content.length > maxSize) || (minSize > 0 && content.length < minSize))
            return FileVisitResult.CONTINUE;

        if (partOfContent != null && !partOfContent.isEmpty()) {
            String contentString = new String(content);
            if (!contentString.contains(partOfContent)) return FileVisitResult.CONTINUE;
        }

        foundFiles.add(file);
        return super.visitFile(file, attrs);
    }

    private boolean contentContain(byte[] content) {
        return partOfContent != null && !partOfContent.isEmpty() && new String(content).contains(partOfContent);
    }

    private boolean isSmallerThanMaxSize(byte[] content) {
        return maxSize != 0 && content.length < maxSize;
    }

    private boolean isBiggerThanMinSize(byte[] content) {
        return minSize != 0 && content.length > minSize;
    }

    private boolean containPartOfName(Path file) {
        return partOfName != null && file.getFileName().toString().contains(partOfName);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
