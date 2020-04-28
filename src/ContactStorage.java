import java.util.ArrayList;
import java.util.List;

public enum ContactStorage {
    INSTANCE;

    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }
}

