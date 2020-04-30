package io.github.phonebook;

import java.util.Scanner;

public class SearchByNameMenuItem implements MenuItemExecutor {
    @Override
    public void execute() {
        System.out.println("Введите имя контакта для поиска.");
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        for (int i = 0; i < ContactStorage.INSTANCE.getContacts().size(); i++) {
            if (scan.equals(ContactStorage.INSTANCE.getContacts().get(i).getFullName())) {
                System.out.println(ContactStorage.INSTANCE.getContacts().get(i).toString());
            }

        }


        Menu mainMenu = new MainMenu();
        mainMenu.printMenu();
        mainMenu.interactWithMenu();
    }
}