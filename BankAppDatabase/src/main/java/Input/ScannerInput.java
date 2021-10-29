package Input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInput {

    private static final Scanner scan = new Scanner(System.in);

    protected int setInt() {
        int newInt = 0;
        try{
            newInt = scan.nextInt();
        }catch (InputMismatchException e){
            scan.nextLine();

        }
        //scan.nextLine();
        return newInt;
    }

    protected double setDouble() {
        double newDouble = 0;
        try{
            newDouble = scan.nextDouble();
        }catch (InputMismatchException e){
            scan.nextLine();
        }
        //scan.nextLine();
        return newDouble;
    }

    protected String setString() {

        return scan.nextLine();
    }

    protected void closeScanner() {
        scan.close();
    }

}
