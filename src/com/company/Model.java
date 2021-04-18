package com.company;

import java.io.*;
import java.util.Scanner;

public class Model {
    private File file;
    private FileWriter fileWriter;
    private Scanner scanner;

    public Model(String path) throws IOException {
        file = new File(path);
        fileWriter = new FileWriter(file , false);
        scanner = new Scanner(file);
        fileWriter.write("");
    }

    public void write(String text) throws IOException {
        fileWriter.append(text + " ");
        fileWriter.flush();
    }

    public String read() throws FileNotFoundException {
        scanner = new Scanner(file);
        scanner.useDelimiter("//");
        return scanner.next();
    }

    public void addRazdelitel(String razdelitel) throws IOException {
        String Text = read();
        String[] arr = Text.split(" ");
        String newText = "";
        for (int i = 0; i < arr.length; i++) {
            newText+=arr[i];
            newText+=razdelitel;
        }
        clear();
        fileWriter.write(newText);
        fileWriter.flush();

    }

    private void clear() throws IOException {
        fileWriter = new FileWriter(file , false);
        fileWriter.write("");
        fileWriter.flush();
    }
}