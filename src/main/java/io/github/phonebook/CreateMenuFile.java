package io.github.phonebook;

import java.io.*;
import java.util.Scanner;

public class CreateMenuFile implements MenuItemExecutor {

    private final Menu MENU;

    public CreateMenuFile(Menu menu) {
        MENU = menu;
    }

    @Override
    public void execute() {
        System.out.println("Укажите путь к файлу:");
        Scanner scanner = new Scanner(System.in);
        String contactFile = scanner.nextLine();
        int lineCount = 0;
        FileWriter outContactFile = null;
        try {
            File file = new File(contactFile);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            Contact contact = null;
            CreateMenuItem createMenuItem = new CreateMenuItem(MENU);
            outContactFile = new FileWriter("out.txt");
            while (line != null) {
                // считываем остальные строки в цикле
                lineCount++;
                try {
                    contact = createMenuItem.parseContactLine(line);
                    ContactStorage.INSTANCE.getContacts().add(contact);
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                    System.err.println("Ошибка в строке № " + lineCount);
                }
                line = reader.readLine();
            }
            for (Contact cont : ContactStorage.INSTANCE.getContacts()) {
                outContactFile.write(cont.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outContactFile != null) {
                    outContactFile.close();
                }
            } catch (IOException e) {
                System.err.println("File problem " + e.getMessage());
            }
        }

        try (
                FileWriter outContactFileX = new FileWriter("out.txt");
                ) {
                outContactFileX.write("2");
        } catch (IOException e) {

        }

        MENU.printMenu();
        MENU.interactWithMenu();
    }
}
