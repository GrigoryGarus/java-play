import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenu implements Menu {
    protected List<MenuItem> items;
    protected String MENU_HEADER = "Please input required menu item:";

    public AbstractMenu() {
        this.items = new ArrayList<>();
    }

    private void printMenuHeader() {
        System.out.println(MENU_HEADER);
    }

    @Override
    public void printMenu() {
        printMenuHeader();

        this.items.forEach(MenuItem::print);
    }
}
