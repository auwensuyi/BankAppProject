package Repository;

import Model.AccountInformation;
import Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetrieveFromDatabase {
    private static boolean userAndPasswordExist(String username, String password, String dbUsername, String dbPassword) {
        return username.equals(dbUsername) && password.equals(dbPassword);
    }

    public static User getUserFromDB(String username, String password) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BankAppSQL?autoReconnect=true&useSSL=false", "root", "dios");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `userinfo` WHERE username = (?) AND password = (?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String dbUsername = rs.getString(1);
                String dbPassword = rs.getString(4);
                if(userAndPasswordExist(username, password,
                        dbUsername, dbPassword)){
                    String firstname = rs.getString(2);
                    String lastname = rs.getString(3);
                    String accountnumber = rs.getString(5);
                    AccountInformation info = getAccountFromDB(accountnumber);
                    return new User(username, firstname, lastname, password, info);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AccountInformation getAccountFromDB(String accountnumber) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BankAppSQL?autoReconnect=true&useSSL=false", "root", "dios");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `accountinfo` WHERE accountnumber = (?)");
            ps.setInt(1, Integer.parseInt(accountnumber));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String dbAccountNumber = Integer.toString(rs.getInt(1));
               if(accountnumber.equals(dbAccountNumber)){
                   double checkingamount = rs.getDouble(2);
                   double savingsamount = rs.getDouble(3);
                   return new AccountInformation(accountnumber, checkingamount, savingsamount);
               }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
