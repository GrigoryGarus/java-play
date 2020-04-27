import java.util.ArrayList;
import java.util.List;

public class Singleton {
    private static Singleton instance;
    private static ArrayList<Contact> contacts;

    public Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
