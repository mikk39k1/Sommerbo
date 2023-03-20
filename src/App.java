import Menu.MenuController;
import Menu.MenuHandler;
import Utility.Ui;

public class App {
    Ui ui = new Ui();
    void run (){
        new MenuController().runMainMenu();
    }

    public static void main(String[] args) {
        new App().run();
    }
}
