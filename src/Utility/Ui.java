package Utility;

import java.util.Scanner;

public class Ui {

    Scanner in = new Scanner(System.in);




    public String readLine(){
        return in.nextLine();
    }

    public int readInt(){
        int interger = in.nextInt();
        in.nextLine();
        return interger;

    }

    public int readDate(){
        System.out.println("Enter year");
        int year = in.nextInt();
        System.out.println("Enter Month");
        int month = in.nextInt();
        System.out.println("Enter Day");
        int day = in.nextInt();

        return Integer.parseInt(year + " " + month + " " + day);
    }
}
