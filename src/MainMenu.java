

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu extends AbstractMenu {

    public MainMenu() {
        super();
        initMenuItems();
    }

    private void initMenuItems() {
        this.items.add(new MenuItem(this.items, "Create", new CreateMenuItem())
        );
        this.items.add(new MenuItem(this.items, "Search", new SearchMenuItem()));
        this.items.add(new MenuItem(this.items, "Delete", new DeleteMenuItem()));
        this.items.add(new MenuItem(this.items, "Search by name", new SearchByNameMenuItem()));
    }

    @Override
    public void interactWithMenu() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            try {
                int choiceNumber = scanner.nextInt();
                System.out.println("Your input " + choiceNumber);
                  this.items.get(choiceNumber-1).interact();
//TODO: тут вы должны реализовать выбор меню без использования циклов. Подсказкой будет использование индексов списка

            } catch (InputMismatchException mismatchException) {
                System.out.println("Invalid input data");
                this.printMenu();
            }
        }
    }
}
