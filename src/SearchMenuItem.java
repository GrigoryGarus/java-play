public class SearchMenuItem implements MenuItemExecutor {


    @Override
    public void execute() {
        for (Contact c: CreateMenuItem.contacts) {
            System.out.println(c.toString());
        }

        Menu mainMenu = new MainMenu();
        mainMenu.printMenu();
        mainMenu.interactWithMenu();
    }
}
