//TODO: Данный класс должен отвечать за обработку ввходных данных в формате -
//Иванов Иван Иванович; 18.06.1983; 34; 6.45; \"Работал над проектами: \"\"АБС\"\"; \"\"КВД\"\"\"
//Иванов Иван Иванович; 18.06.1983; 34; 6,45; "Работал над проектами: ""АБС""; ""КВД"""
//и создание объекта Contact

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CreateMenuItem implements MenuItemExecutor {

    private final Menu MENU;

    public CreateMenuItem(Menu menu) {
        this.MENU = menu;
    }

    @Override
    public void execute() {
        // читаем строку из консоли
        Scanner scanner = new Scanner(System.in);
        String contactLineFromCLI = scanner.nextLine();

        // парсим строку
        Contact contact = null;
        try {
            contact = this.pareseContactLine(contactLineFromCLI);
            ContactStorage.INSTANCE.getContacts().add(contact);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        MENU.printMenu();
        MENU.interactWithMenu();
    }

    private Contact pareseContactLine(String contactLine) throws IOException {
        Contact contact = null;

        String[] scanArray = contactLine.split(";");

        if (scanArray.length < 4) {
            throw new IOException("Invalid contact data");
        }

        int INDEX_FULLNAME = 0;
        String fullName = scanArray[INDEX_FULLNAME].trim();
        String dob1 = scanArray[1].trim();
        String countOfProjects1 = scanArray[2].trim();
        String rating1 = scanArray[3].trim().replaceAll(",", ".");

        try {
            Date dob = new SimpleDateFormat("dd.MM.yyyy").parse(dob1);
            int countOfProjects = Integer.parseInt(countOfProjects1);
            float rating = Float.parseFloat(rating1);
            String[] comment = Arrays.copyOfRange(scanArray, 4, scanArray.length);
            String comments = Arrays.toString(comment);

            contact = new Contact(fullName, dob, countOfProjects, rating, comments);

        } catch (ParseException e) {
            throw new IOException("Invalid contact data");
        }

        return contact;
    }
}
