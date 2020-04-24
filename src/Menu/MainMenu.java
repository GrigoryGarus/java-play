package Menu;

public class MainMenu extends AbstractMenu {

    public MainMenu() {
        super();
        initMenuItems();
    }

    private void initMenuItems() {
        this.items.add("Create");
        this.items.add("Search");
        this.items.add("Sort");
    }

    @Override
    public void interactWithMenu() {
//TODO: Обработка ввода и вызов метода контроллера
    }
}