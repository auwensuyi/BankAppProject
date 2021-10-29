package Menu;

import Input.ScannerInput;

public class MenuDisplay extends ScannerInput {

    public int mainMenu() {
        int choice = 0;
        while (choice <= 0 || choice > 3) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            menuPrompt();

            choice = setInt();
        }
        return choice;
    }

    public int userMenu() {
        int option = 0;
        while (option <=0 || option > 4) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Logout");
            menuPrompt();

            option = setInt();
        }
        return option;
    }

    public int accountMenu() {
        int accountOption = 0;
        while (accountOption <=0 || accountOption > 3) {
            System.out.println("1. Checking");
            System.out.println("2. Savings");
            System.out.println("3. Exit");
            menuPrompt();

            accountOption = setInt();
        }
        return accountOption;
    }

    public int transferMenu() {
        int transferOption = 0;
        while (transferOption <=0 || transferOption > 4) {
            System.out.println("1. Checking to Savings");
            System.out.println("2. Savings to Checking");
            System.out.println("3. Go Back");
            System.out.println("4. Exit");
            menuPrompt();

            transferOption = setInt();
        }
        return transferOption;
    }

    public void menuPrompt() {
        System.out.print("Please choose any of the available options: ");
    }
}
