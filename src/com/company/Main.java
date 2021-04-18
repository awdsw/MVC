package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        Model model = new Model("demoFile.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String action;
        String word;
        do {
            System.out.println("1 - Записать в File");
            System.out.println("2 - Прочесть из File");
            System.out.println("3 - Добавить разделители в File");
            action = reader.readLine();
            if (action.equals("1")) {
                System.out.println("Введите слово для записи");
                word = reader.readLine();
                if (!controller.checkWordSave(word)){
                    System.out.println("Cлово записано");
                }else {
                    System.out.println("Cлово не записано так как оно запрещённое");
                }
            } else if (action.equals("2")) {
                System.out.println("Чтение из File");
                System.out.println(controller.read());
            } else if (action.equals("3")) {
                System.out.println("Введите разделитель");
                word = reader.readLine();
                controller.addRazdelitel(word);
            }
        } while (true);
    }
}
