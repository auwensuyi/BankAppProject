package Model;

public class User {
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private AccountInformation userAccount;

    public User() {

    }
    public User(String username, String firstname, String lastname, String password, String accountnumber) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.userAccount = new AccountInformation(accountnumber);
    }

    public User(String username, String firstname, String lastname, String password, AccountInformation userAccount) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.userAccount = userAccount;
    }

    public User(String username, String firstname, String lastname, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountInformation getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(AccountInformation userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", userAccount=" + userAccount +
                '}';
    }
}
