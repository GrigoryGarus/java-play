package io.github.phonebook;

//TODO: Данный класс должен отвечать за обработку ввходных данных в формате -
//Иванов Иван Иванович; 18.06.1983; 34; 6.45; \"Работал над проектами: \"\"АБС\"\"; \"\"КВД\"\"\"
//Иванов Иван Иванович; 18.06.1983; 34; 6,45; "Работал над проектами: ""АБС""; ""КВД"""
//Петров Петр Васильевич; 18.06.1983; 34; 6,45; "Работал над проектами: ""АБС""; ""КВД"""
//Авакян Арен Васильевич; 18.06.1983; 34; 6,45; "Работал над проектами: ""АБС""; ""КВД"""


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CreateMenuItem implements MenuItemExecutor {

    private final Menu MENU;
    public CreateMenuItem(Menu menu) {
        MENU = menu;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String contactLine = scanner.nextLine();

        Contact contact = null;
        try {
            contact = this.parseContactLine(contactLine);
            ContactStorage.INSTANCE.getContacts().add(contact);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        MENU.printMenu();
        MENU.interactWithMenu();
    }


    public Contact parseContactLine(String contactLine) throws IOException {

        Contact contact = null;

        String[] scanArray = contactLine.split(";");

        if (scanArray.length < 4) {
            throw new IOException("Invalid contact data");
        }

        int INDEX_FULLNAME = 0;
        int INDEX_DATE = 1;
        int INDEX_COUNT_OF_PROJECTS = 2;
        int INDEX_RATING = 3;

        String fullName = scanArray[INDEX_FULLNAME].trim();
        String dobStr = scanArray[INDEX_DATE].trim();
        String countOfProjectsStr = scanArray[INDEX_COUNT_OF_PROJECTS].trim();
        String ratingStr = scanArray[INDEX_RATING].trim().replaceAll(",", ".");

        try {
            Date dob = new SimpleDateFormat("dd.MM.yyyy").parse(dobStr);
            int countOfProjects = Integer.parseInt(countOfProjectsStr);
            float rating = Float.parseFloat(ratingStr);
            String[] comment = Arrays.copyOfRange(scanArray, 4, scanArray.length);
            String comments = Arrays.toString(comment);


            contact = new Contact(fullName, dob, countOfProjects, rating, comments);
            System.out.println(contact.toString());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return contact;
    }


}
