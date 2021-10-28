package Input;

//Getting user input using the scanner
public class UserInput extends ScannerInput{

    private String inputUserName() {
        String userName = "";
        //while username is blank it will continue to ask for username
        while(userName.isBlank()){
            System.out.print("Please enter username: ");
            userName = setString();
        }
        return userName;
    }

    private String inputPassword(){
        String password = "";
        while (password.isBlank()){
            System.out.print("Please enter password: ");
            password = setString();
        }
        return password;
    }

    private String inputFirstName(){
        String firstName = "";
        while(firstName.isBlank()){
            System.out.print("Please enter first name: ");
            firstName = setString();
        }
        return firstName;
    }

    private String inputLastName(){
        String lastName = "";
        while(lastName.isBlank()){
            System.out.print("Please enter last name: ");
            lastName = setString();
        }
        return lastName;
    }

    private double inputWithdraw(){
        double Withdraw = 0;
        while(Withdraw <= 0){
            System.out.print("Please enter withdrawal amount: $");
            Withdraw = setDouble();
        }
        return Withdraw;
    }

    private double inputDeposit(){
        double Deposit = 0;
        while(Deposit <= 0){
            System.out.print("Please enter deposit amount: $");
            Deposit = setDouble();
        }
        return Deposit;
    }

    private double inputTransfer(double amount){
        double Transfer = 0;
        while(Transfer <= 0 || Transfer > amount){
            System.out.print("How much do you want to transfer?: $");
            Transfer = setDouble();
            transferMessage(amount, Transfer);
        }
        return Transfer;
    }

    private void transferMessage(double amount, double Transfer){
        if(Transfer == 0){
            System.out.println("Please enter an amount greater than 0.");
        }else if(Transfer > amount){
            System.out.println("Warning Overdraft: The amount you've entered $" + Transfer
                    + " is greater than the amount in the account $" + amount);
        }
    }

    public static void main(String[] args) {
        UserInput a = new UserInput();

        //String userName = a.inputUserName();
        //double withdrawal = a.inputWithdraw();
        double Transfer = a.inputTransfer(500);
    }

}
