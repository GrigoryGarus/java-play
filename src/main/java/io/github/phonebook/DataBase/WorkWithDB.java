package io.github.phonebook.DataBase;

import io.github.phonebook.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkWithDB extends AbstractMenu implements MenuItemExecutor {
    public WorkWithDB() {
        super();
        initMenuItems();
    }

    private void initMenuItems() {
        this.items.add(new MenuItem(this.items, "Create", new CreateMenuDB()));
        this.items.add(new MenuItem(this.items, "Search", new SearchDB()));
        this.items.add(new MenuItem(this.items, "Update", new UpdateDB()));
        this.items.add(new MenuItem(this.items, "Delete", new DeleteDB()));
    }

    @Override
    public void interactWithMenu() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            try {
                int choiceNumber = scanner.nextInt();
                System.out.println("Your input " + choiceNumber);
                this.items.get(choiceNumber - 1).interact();
            } catch (InputMismatchException mismatchException) {
                System.out.println("Invalid input data");
                this.printMenu();
            }
        }
    }

    @Override
    public void execute() {
        printMenu();
        interactWithMenu();
    }
}
