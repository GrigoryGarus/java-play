//TODO: Данный класс должен отвечать за обработку ввходных данных в формате - 
//Иванов Иван Иванович; 18.06.1983; 34; 6.45; \"Работал над проектами: \"\"АБС\"\"; \"\"КВД\"\"\"
//и создание объекта Contact

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CreateMenuItem implements MenuItemExecutor {


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String scan  = scanner.nextLine();
        String[] scanArray = scan.split(";");
        System.out.println(Arrays.toString(scanArray));

        String fullName = scanArray[0].trim();
        String dob1 = scanArray[1].trim();
        String countOfProjects1 = scanArray[2].trim();
        String rating1 = scanArray[3].trim();

        try {
            Date dob = new SimpleDateFormat("dd.MM.yyyy").parse(dob1);
            int countOfProjects = Integer.parseInt(countOfProjects1);
            float rating = Float.parseFloat(rating1);
            String[] comment = Arrays.copyOfRange(scanArray, 4, scanArray.length);
            String comments = comment.toString();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Contact contact = new Contact(fullName, );

    }
}