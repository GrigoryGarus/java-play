//TODO: Данный класс должен отвечать за обработку ввходных данных в формате - 
//Иванов Иван Иванович; 18.06.1983; 34; 6.45; \"Работал над проектами: \"\"АБС\"\"; \"\"КВД\"\"\"
//Иванов Иван Иванович; 18.06.1983; 34; 6,45; "Работал над проектами: ""АБС""; ""КВД"""
//и создание объекта Contact

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CreateMenuItem implements MenuItemExecutor {

    private static ArrayList<Contact> contacts =new ArrayList<Contact>();

    public static ArrayList<Contact> getContacts() {
        return contacts;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String scan  = scanner.nextLine();
        String[] scanArray = scan.split(";");
        //System.out.println(Arrays.toString(scanArray));


        String fullName = scanArray[0].trim();
        String dob1 = scanArray[1].trim();
        String countOfProjects1 = scanArray[2].trim();
        String rating1 = scanArray[3].trim().replaceAll(",", ".");




        try {
            Date dob = new SimpleDateFormat("dd.MM.yyyy").parse(dob1);
            int countOfProjects = Integer.parseInt(countOfProjects1);
            float rating = Float.parseFloat(rating1);
            String[] comment = Arrays.copyOfRange(scanArray, 4, scanArray.length);
            String comments = Arrays.toString(comment);

            Contact contact = new Contact(fullName, dob, countOfProjects, rating, comments);
            System.out.println(contact.toString());


            Singleton singleton = new Singleton();
          contacts.add(contact);


        } catch (ParseException e) {
            e.printStackTrace();
        }

        Menu mainMenu = new MainMenu();
        //mainMenu.printMenu();
        mainMenu.interactWithMenu();


    }
}