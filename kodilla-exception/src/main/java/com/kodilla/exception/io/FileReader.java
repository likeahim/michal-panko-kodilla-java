package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("names.txt").getFile());

        try (Stream<String> filesLines = Files.lines(Paths.get(file.getPath()))) {
            filesLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Something went wrong " + e);
        } finally {
            System.out.println("i'm gonna be here... always");
        }

        System.out.println(file.getPath());
    }
}
