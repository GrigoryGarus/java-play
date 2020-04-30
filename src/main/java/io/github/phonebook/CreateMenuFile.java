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
        int lineCount=0;
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
            FileWriter nFile = new FileWriter("//C:/prj/test2.txt");
            while (line != null) {
                // считываем остальные строки в цикле
                 lineCount++;
                try {
                    contact=createMenuItem.parseContactLine(line);
                    ContactStorage.INSTANCE.getContacts().add(contact);


                } catch (IOException e) {
                    System.err.println(e.getMessage());
                    System.err.println("Ошибка в строке № "+lineCount);
                }



                line = reader.readLine();

            }
            for (Contact cont:ContactStorage.INSTANCE.getContacts()
                 ) {nFile.write(cont.toString());

            }
            nFile.close();

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
