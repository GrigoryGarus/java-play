public class SearchMenuItem implements MenuItemExecutor {


    @Override
    public void execute() {
        for (Contact c: CreateMenuItem.getContacts()) {
            System.out.println(c.toString());
        }

        Menu mainMenu = new MainMenu();
        mainMenu.printMenu();
        mainMenu.interactWithMenu();
    }
}
