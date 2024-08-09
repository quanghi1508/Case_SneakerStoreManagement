import Utility.EmptyFileException;
import controllers.DisplayAccountMenu;
import controllers.SneakerController;

public class Main {
    public static void main(String[] args) throws EmptyFileException {

        DisplayAccountMenu displayAccountMenu = new DisplayAccountMenu();
        displayAccountMenu.displayAccountMenu();
    }
}