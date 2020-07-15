package io.github.phonebook;

import java.util.Collections;
import java.util.Scanner;

public class SearchByNameMenuItem implements MenuItemExecutor {
    @Override
    public void execute() {
        System.out.println("Введите имя контакта для поиска.");
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();

        ContactStorage.INSTANCE.getContacts().sort(Contact::compareTo);

        int foundedContactIndex = Collections.binarySearch(
                ContactStorage.INSTANCE.getContacts(),
                new Contact(scan),
                Contact::compareTo
        );

        try {
            Contact foundedContact = ContactStorage.INSTANCE.getContacts().get(foundedContactIndex);
            System.out.println(foundedContact.toString());
        } catch (NullPointerException ex){
            System.err.println("Contact with name " + scan + " not found");
        }

//        for (int i = 0; i < ContactStorage.INSTANCE.getContacts().size(); i++) {
//            if (scan.equals(ContactStorage.INSTANCE.getContacts().get(i).getFullName())) {
//                System.out.println(ContactStorage.INSTANCE.getContacts().get(i).toString());
//            }
//
//        }

        Menu mainMenu = new MainMenu();
        mainMenu.printMenu();
        mainMenu.interactWithMenu();
    }
}
