import java.util.Scanner;

public class DeleteMenuItem implements MenuItemExecutor {

    @Override
    public void execute() {

        System.out.println("Введите имя контакта для удаления.");
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
//        for (Contact c : CreateMenuItem.contacts) {
//            if (scan.equals(c.getFullName())) {
//                CreateMenuItem.contacts.remove(c);
//            }
//        }
        for (int i = 0; i <CreateMenuItem.getContacts().size() ; i++) {
            if (scan.equals(CreateMenuItem.getContacts().get(i).getFullName())) {
                CreateMenuItem.getContacts().remove(CreateMenuItem.getContacts().get(i));
            }

        }
        System.out.println("Контакт удален.");
        Menu mainMenu = new MainMenu();
        mainMenu.printMenu();
        mainMenu.interactWithMenu();
    }
}
