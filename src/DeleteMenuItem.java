import java.util.Scanner;

public class DeleteMenuItem implements MenuItemExecutor {

    @Override
    public void execute() {

        System.out.println("Введите имя контакта для удаления.");
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        for (Contact c : CreateMenuItem.contacts) {
            if (scan.equals(c.getFullName())) {
                CreateMenuItem.contacts.remove(c);
            }
        }
    }
}
