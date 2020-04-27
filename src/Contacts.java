import java.util.ArrayList;

public class Contacts {

    public static ArrayList<Contact> contacts;

    public static ArrayList<Contact> getContacts() {
        return contacts;
    }

    public static void setContacts(ArrayList<Contact> contacts) {
        Contacts.contacts = contacts;
    }
}
