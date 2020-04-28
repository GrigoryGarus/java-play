import java.util.List;

public class MenuItem {
    private final int number;
    private final String name;
    private final MenuItemExecutor executor;

    public MenuItem(List items, String name, MenuItemExecutor executor) {
        this.number = items.size() + 1;
        this.name = name;
        this.executor = executor;
    }

    public void interact() {
        this.executor.execute();
    }

    public void print() {
        String menuElement = this.number + " - " + name;
        System.out.println(menuElement);
    }
}
