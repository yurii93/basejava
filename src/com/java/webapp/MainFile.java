package com.java.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        System.out.println("===========");

        File dir = new File(".\\src\\com\\java\\webapp");
        System.out.println(dir.isDirectory());
        System.out.println("===========");

        System.out.println(Arrays.toString(dir.list()));
        System.out.println("===========");

        for (String name : Objects.requireNonNull(dir.list())) {
            System.out.println(name);
        }
        System.out.println("===========");

        try(FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File baseDir = new File(".\\src");
        printDirectoryRecursively(baseDir, 0);
    }

    private static void printDirectoryRecursively(File directory, int offset) {

        String offsetSpace = " ";
        String spaceRepeated = IntStream.range(0, offset).mapToObj(i -> offsetSpace).collect(Collectors.joining(""));

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                System.out.println(spaceRepeated + "== " + file.getName() + " ==");
                printDirectoryRecursively(file, offset + 2);
            } else {
                System.out.println(spaceRepeated + "-" + file.getName());
            }
        }
    }
}
