import java.awt.*;
import java.util.Scanner;

public class SearchByNameMenuItem implements MenuItemExecutor {
    @Override
    public void execute() {
        System.out.println("Введите имя контакта для поиска.");
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        for (int i = 0; i < CreateMenuItem.getContacts().size(); i++) {
            if (scan.equals(CreateMenuItem.getContacts().get(i).getFullName())) {
                System.out.println(CreateMenuItem.getContacts().get(i).toString());
            }

        }


        Menu mainMenu = new MainMenu();
        mainMenu.printMenu();
        mainMenu.interactWithMenu();
    }
}
