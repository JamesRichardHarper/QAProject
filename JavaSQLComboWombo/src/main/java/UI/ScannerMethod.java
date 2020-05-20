package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerMethod {

    public static Scanner Scan = new Scanner(System.in);

    public static String inputString(){
        String input = "";

        input = Scan.nextLine();

        return input;
    }

    public static int inputNum(){
        int input = 0;

        if(Scan.hasNextInt()){
            input = Scan.nextInt();
            Scan.nextLine();
        }
        else{
            System.out.println("Sorry! It appears you have entered an incorrect variable. Returning to previous menu.");
            Scan.nextLine();
        }
        
        return input;
    }

}
