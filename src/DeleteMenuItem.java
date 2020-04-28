import java.util.Scanner;

public class DeleteMenuItem implements MenuItemExecutor {

    @Override
    public void execute() {

        System.out.println("Введите имя контакта для удаления.");
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();

        for (int i = 0; i < ContactStorage.getInstance().getContacts().size(); i++) {
            if (scan.equals(ContactStorage.getInstance().getContacts().get(i).getFullName())) {
                ContactStorage.getInstance().getContacts().remove(ContactStorage.getInstance().getContacts().get(i));
            }

        }
        System.out.println("Контакт удален.");
        Menu mainMenu = new MainMenu();
        mainMenu.printMenu();
        mainMenu.interactWithMenu();
    }
}
