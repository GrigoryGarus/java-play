package Menu;

import java.util.Scanner;

public class MainMenu extends AbstractMenu {

    public MainMenu() {
        super();
        initMenuItems();
    }

    private void initMenuItems() {
        this.items.add("Create");
        this.items.add("Search");
        this.items.add("Sort");
    }

    @Override
    public void interactWithMenu() {
//TODO: Обработка ввода и вызов метода контроллера
        System.out.println("test1");
    }

    @Override
    public void searchByName() {
        System.out.println("test2");
    }

    @Override
    public void sortWithYear() {
        System.out.println("test3");
    }

    @Override
    public void interactiveMenu() {
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        if (choice.equals("1")) {
            interactWithMenu();
        } else if (choice.equals("2")) {
            searchByName();
        } else if (choice.equals("3")) {
            sortWithYear();
        } else {
            System.out.println("Ошибка ввода. Повторите");
            interactiveMenu();

        }

    }
}