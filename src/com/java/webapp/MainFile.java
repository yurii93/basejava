package com.java.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

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

    }
}
