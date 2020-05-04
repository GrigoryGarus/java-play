package io.github.phonebook.MenuItems;

import io.github.phonebook.*;

import java.io.*;
import java.util.Scanner;

public class CreateMenuFile implements MenuItemExecutor {
//C:/prj/test.txt
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
        File file = new File(contactFile);
        try ( FileReader fr = new FileReader(file);
              BufferedReader reader = new BufferedReader(fr);
              FileWriter outContactFile = new FileWriter("out.txt")) {

            //создаем объект FileReader для объекта File
            //создаем BufferedReader с существующего FileReader для построчного считывания
            // считаем сначала первую строку
            String line = reader.readLine();
            Contact contact = null;
            CreateMenuItem createMenuItem = new CreateMenuItem(MENU);

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
        }

        MENU.printMenu();
        MENU.interactWithMenu();
    }
}
