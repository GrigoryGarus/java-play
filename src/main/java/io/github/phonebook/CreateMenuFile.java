package io.github.phonebook;

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

        try {
            File file = new File(contactFile);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();

            int lineCount=0;
            while (line != null) {
                // считываем остальные строки в цикле
                 lineCount++;

                Contact contact = null;

                try {
                    CreateMenuItem createMenuItem = new CreateMenuItem(MENU);
                    contact=createMenuItem.parseContactLine(line);
                    ContactStorage.INSTANCE.getContacts().add(contact);
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                    System.err.println("Ошибка в строке № "+lineCount);
                }



                line = reader.readLine();

            }
            //System.out.println(contactLine);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        MENU.printMenu();
        MENU.interactWithMenu();
    }
}
