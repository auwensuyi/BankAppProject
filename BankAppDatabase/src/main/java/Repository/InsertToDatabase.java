package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertToDatabase {
    public static boolean InsertUserInfo(String username, String firstname, String lastname, String password, String accountnumber) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BankAppSQL?autoReconnect=true&useSSL=false", "root", "dios");
            PreparedStatement ps = con.prepareStatement("insert into `userinfo` values(?, ?, ?, ?, ?) ");
            ps.setString(1, username);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setString(4, password);
            ps.setInt(5, Integer.parseInt(accountnumber));
            ps.execute();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nInsert Into User Table Is Not Working\n");
            return false;
        }
        return true;
    }

    public static boolean InsertAccountInfo(String accountnumber, double checkingamount, double savingsamount){
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BankAppSQL?autoReconnect=true&useSSL=false", "root", "dios");
            PreparedStatement ps = con.prepareStatement("insert into `accountinfo` values(?, ?, ?) ");
            ps.setInt(1, Integer.parseInt(accountnumber));
            ps.setDouble(2, checkingamount);
            ps.setDouble(3, savingsamount);
            ps.execute();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nInsert Into Account Table Is Not Working\n");
            return false;
        }
        return true;
    }
}
