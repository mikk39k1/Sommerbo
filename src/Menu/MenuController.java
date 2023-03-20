package Menu;

import Database.DB_Dependencies;
import Database.DB_EditingHandler;
import Database.DB_RequestHandler;
import Utility.Ui;

import java.sql.ResultSet;

public class MenuController {
    Ui ui;
    MenuHandler menuHandler;

    DB_RequestHandler db_requestHandler;

    DB_Dependencies db_dependencies;

    DB_EditingHandler db_editingHandler;

    public static boolean inEmployeeMenu = false;


    public MenuController(){
        ui = new Ui();
        menuHandler = new MenuHandler();
        db_requestHandler = new DB_RequestHandler();
        db_dependencies = new DB_Dependencies();
        db_editingHandler = new DB_EditingHandler();
    }

    public void runMainMenu(){
        boolean isRunning = true;
        while (isRunning){
            menuHandler.mainMenu.printMenu();
            switch (ui.readInt()){
                case 1 -> {
                    System.out.println("Search for house");
                }
                case 2 -> {
                    runEmployeeMenu();
                }
                case 3 -> {
                    runRenterMenu();
                }
                case 9 -> {
                    isRunning = false;
                }
                default -> {
                    System.out.println("Please choose a valid option");
                }
            }
        }
    }

    public void runEmployeeMenu(){
        boolean isRunning = true;
        inEmployeeMenu = true;
        if (logIn(db_requestHandler)){
            while (isRunning){
                menuHandler.employeeMenu.printMenu();
                switch (ui.readInt()){
                    case 1 -> {
                        db_editingHandler.insertIntoQuery
                                ("renter",db_dependencies.RENTER_INSERT_COLUMNS,db_dependencies);
                    }
                    case 2 -> {
                        System.out.println("Create New Renter");
                    }
                    case 3 -> {
                        System.out.println("Add new employee");
                    }
                    case 9 -> {
                        isRunning = false;
                        inEmployeeMenu = false;
                    }
                    default -> {
                        System.out.println("Please choose a valid option");
                    }
                }
            }
        } else {
            System.out.println("Incorrect Login information");
        }

    }

    public void runRenterMenu(){
        boolean isRunning = true;
        if (logIn(db_requestHandler)) {
            while (isRunning) {
                menuHandler.renterMenu.printMenu();
                switch (ui.readInt()) {
                    case 1 -> {
                        System.out.println("Show my houses");
                    }
                    case 2 -> {
                        System.out.println("Change house availability");
                    }
                    case 3 -> {
                        System.out.println("Register a new house");
                    }
                    case 9 -> {
                        isRunning = false;
                    }
                    default -> {
                        System.out.println("Please choose a valid option");
                    }
                }
            }
        }
    }


    public boolean logIn(DB_RequestHandler db_requestHandler){
        System.out.println("Enter your Username:");
        String username = ui.readLine();
        System.out.println("Enter your Password:");
        String password = ui.readLine();

        String sqlQuery = "SELECT " + (inEmployeeMenu ? "employee_username, employee_password" : "renter_username, renter_password") + "\n" +
                "FROM " + (inEmployeeMenu ? "employee" : "renter") + "\n" +
                "WHERE " + (inEmployeeMenu ? "employee_username" : "renter_username") + " = \"" + username + "\" AND " + (inEmployeeMenu ? "employee_password" : "renter_password") + " = \"" + password + "\"";





        return db_requestHandler.checkLoginInfo(db_dependencies,sqlQuery,username,password);
    }

}
