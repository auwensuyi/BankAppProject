package Input;

import java.util.Random;

//Getting user input using the scanner
public class UserInput extends ScannerInput{

    protected String inputUserName() {
        String userName = "";
        //while username is blank it will continue to ask for username
        while(userName.isBlank()){
            System.out.print("Please enter username: ");
            userName = setString();
        }
        return userName;
    }

    protected String inputPassword(){
        String password = "";
        while (password.isBlank()){
            System.out.print("Please enter password: ");
            password = setString();
        }
        return password;
    }

    protected String inputFirstName(){
        String firstName = "";
        while(firstName.isBlank()){
            System.out.print("Please enter first name: ");
            firstName = setString();
        }
        return firstName;
    }

    protected String inputLastName(){
        String lastName = "";
        while(lastName.isBlank()){
            System.out.print("Please enter last name: ");
            lastName = setString();
        }
        return lastName;
    }

    protected double inputWithdraw(){
        double Withdraw = 0;
        while(Withdraw <= 0){
            System.out.print("Please enter withdrawal amount: $");
            Withdraw = setDouble();
        }
        return Withdraw;
    }

    protected double inputDeposit(){
        double Deposit = 0;
        while(Deposit <= 0){
            System.out.print("Please enter deposit amount: $");
            Deposit = setDouble();
        }
        return Deposit;
    }

    protected double inputTransfer(double amount){
        double Transfer = 0;
        while(Transfer <= 0 || Transfer > amount){
            System.out.print("How much do you want to transfer?: $");
            Transfer = setDouble();
            transferMessage(amount, Transfer);
        }
        return Transfer;
    }

    protected void transferMessage(double amount, double Transfer){
        if(Transfer == 0){
            System.out.println("Please enter an amount greater than 0.");
        }else if(Transfer > amount){
            System.out.println("Warning Overdraft: The amount you've entered $" + Transfer
                    + " is greater than the amount in the account $" + amount);
        }
    }

    protected String randomAccountGenerator() {
        Random random = new Random();
        String accountNumber = "";
        for(int i = 0; i < 9; i++) {
            accountNumber += random.nextInt(9);
        }
        return accountNumber;
    }

}
