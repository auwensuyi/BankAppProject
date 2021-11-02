package Service;

import Input.UserInput;
import Model.AccountInformation;
import Model.User;
import Repository.InsertToDatabase;
import Repository.RetrieveFromDatabase;

//TODO --Error Handling for username
//TODO --Error Handling for accountnumber

public class MainMenuMethods extends UserInput {

    public User Login() {
        System.out.println("Hello! Welcome to the Login Page!");
        String username = inputUserName();
        String password = inputPassword();
        return RetrieveFromDatabase.getUserFromDB(username, password);
    }

    public User Register() {
        System.out.println("Hello! Welcome to the Registration Page!");
        String firstname = inputFirstName();
        String lastname = inputLastName();
        String username = inputUserName();
        String password = inputPassword();
        String accountnumber = randomAccountGenerator();
        boolean saved = SaveNewInfoToDatabase(firstname, lastname, username, password, accountnumber);
        if(!saved) return null;
        SaveAccountInfoToDatabase(accountnumber);
        return new User(username, firstname, lastname, password, accountnumber);
    }

    public boolean SaveNewInfoToDatabase(String firstname, String lastname,
                                      String username, String password, String accountnumber) {
        return InsertToDatabase.InsertUserInfo(username, firstname, lastname, password, accountnumber);

    }

    public void SaveAccountInfoToDatabase(String accountnumber) {
        InsertToDatabase.InsertAccountInfo(accountnumber, 0, 0);
    }

    public AccountInformation GetInfo(String accountnumber) {
        return RetrieveFromDatabase.getAccountFromDB(accountnumber);
    }

    public void Exit() {
        System.out.println("You will be exiting this page.");
        closeScanner();
    }

    public static void main(String[] args) {
        MainMenuMethods user = new MainMenuMethods();
        User newUser = user.Login();
        String result = (newUser != null) ? newUser.toString() : "User does not exist!!!";
        System.out.println(result);
        //user.Register();

    }
}
