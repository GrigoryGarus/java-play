package io.github.phonebook;

import java.util.Scanner;

public class SearchMenuItem implements MenuItemExecutor {

    @Override
    public void execute() {
        for (Contact c : ContactStorage.INSTANCE.getContacts()) {
            System.out.println(c.toString());
        }
        System.out.println("Введите комментарий контакта для поиска.");
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        for (int i = 0; i < ContactStorage.INSTANCE.getContacts().size(); i++) {
            if (scan.contains(ContactStorage.INSTANCE.getContacts().get(i).getComments())) {
                System.out.println(ContactStorage.INSTANCE.getContacts().get(i).toString());
            }
        }

        Menu mainMenu = new MainMenu();
        mainMenu.printMenu();
        mainMenu.interactWithMenu();
    }
}
