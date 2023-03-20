package Menu;

import Menu.subMenus.EmployeeMenu;
import Menu.subMenus.MainMenu;
import Menu.subMenus.RenterMenu;

public class MenuHandler {

    MainMenu mainMenu = new MainMenu("MAIN MENU", new String[]
            {"1. Search for a house",
            "2. Employee Log In",
            "3. Renter Log In",
            "9. EXIT"});


    EmployeeMenu employeeMenu = new EmployeeMenu("EMPLOYEE MENU",new String[]
            {"1. Add new Renter",
            "2. Create new Rental",
            "3. Add new employee",
            "9. Return to Main Menu"});



    RenterMenu renterMenu = new RenterMenu("RENTER MENU",new String[]
            {"1. Show my Houses",
            "2. Change House Availability",
            "3. Register a new House",
            "9. Return to Main Menu"});
}
