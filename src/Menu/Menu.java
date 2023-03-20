package Menu;

public abstract class Menu {

    private String[] menuItems;

    private String leadText;

    private String headerText;

    public void printMenu(){
        System.out.println(headerText);
        for(String item : menuItems){
            System.out.println(item);
        }
        System.out.println(leadText);
    }

    public Menu(String menuheader, String[] menuItems){
        this.headerText = menuheader;
        this.menuItems = menuItems;
        this.leadText = "PLEASE CHOOSE";
    }


}
