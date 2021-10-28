package Model;

public class AccountInformation {
    private String accountNumber;
    private double checkingAccount;
    private double savingsAccount;

    public AccountInformation(String accountNumber, double checkingAccount, double savingsAccount) {
        this.accountNumber = accountNumber;
        this.checkingAccount = checkingAccount;
        this.savingsAccount = savingsAccount;
    }

    public AccountInformation(String accountNumber) {
        this.accountNumber = accountNumber;
        this.checkingAccount = 0;
        this.savingsAccount = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(double checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public double getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(double savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    @Override
    public String toString() {
        return "AccountInformation{" +
                "accountNumber='" + accountNumber + '\'' +
                ", checkingAccount=" + checkingAccount +
                ", savingsAccount=" + savingsAccount +
                '}';
    }
}
