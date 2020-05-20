package UI;
import java.util.Scanner;

public class InteractText {

    public static void listDatabaseInteract(){

        System.out.println("Here is a list of our tables, which one would you like to access?");
        System.out.println("[1] Location");
        System.out.println("[2] Customer");
        System.out.println("[3] Order");
        System.out.println("[4] Game");
        System.out.println("[5] Order_Game");
        System.out.println("[6] Options");
        System.out.println("[9] Exit");
    }

    public static void listInteract(){

        System.out.println("How would you like to interact with the table?");
        System.out.println("[1] Create");
        System.out.println("[2] Read");
        System.out.println("[3] Update");
        System.out.println("[4] Delete");
        System.out.println("[5] Return");
    }

    public static void selectStatement(){
        System.out.println("How would you like to select?");
        System.out.println("[1] One Row");
        System.out.println("[2] Multiple Rows");
        System.out.println("[3] All Rows");
        System.out.println("[4] Return");
    }

    public static void options(){
        System.out.println("What would you like to access?");
        System.out.println("[1] Connection URL");
        System.out.println("[2] User");
        System.out.println("[3] Password");
        System.out.println("[4] Author");
        System.out.println("[5] Return");
    }
}
