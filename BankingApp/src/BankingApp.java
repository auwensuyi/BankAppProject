import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {
		
		BankAccount obj1 = new BankAccount("Boye","AU1992",134678.87);
		obj1.Menu();

	}

}

//Bank account with a balance that change with deposits and withdrawals.

class BankAccount {
	
	double balance;
	double deposit;
	double withdrawal;
	double recentTransaction;
	double openingBalance;
	String customerName;
	String customerId;
	
	BankAccount(String userName, String userId, double openingBalance) {
		
		customerName = userName;
		customerId = userId;
		balance = openingBalance;
		openingBalance = 0;
	}
	
	//Money that is deposited into BankAccount
	void deposit(double amount) {
		
		if(amount > 0) {
			balance = balance + amount;
			recentTransaction = amount;
		}
	}
	
	//Money that is withdrawn from BankAccount
	void withdrawal(double amount) {
		if(amount > 0) {
			balance = balance - amount;
			recentTransaction = -amount;
		}else {
			System.out.println("Transaction cannot be completed!");
		}
	}
	
	//Money that was deposited or withdrawn...or no transaction took place
	void getRecentTransaction() {
		if(recentTransaction > 0) {
			System.out.println("Deposited: "+recentTransaction);
		
		}else if(recentTransaction <= 0) {
			System.out.println("Withdrawn:"+recentTransaction);
			
		}else {
			System.out.println("No Transaction has occured!");
		}
	}
	
	void Menu() {
		
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hello "+customerName);
		System.out.println("Your ID is "+customerId);
		System.out.println("Current Balance: $"+balance);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdrawal");
		System.out.println("D. Recent transaction");
		System.out.println("E. Exit");
		
		
		do {
			System.out.println("==============================================================");
			System.out.println("Enter an option");
			System.out.println("==============================================================");
			option = scanner.next().charAt(0);
			System.out.println("\n");

			
			switch(option) {
			
			case 'A':
				System.out.println("========================================");
				System.out.println("balance = $"+balance);
				System.out.println("========================================");
				System.out.println("\n");
				break;
			
			case 'B':
				System.out.println("========================================");
				System.out.println("Enter the amount you to deposit:");
				System.out.println("========================================");
				try {
				double amount = scanner.nextDouble();
				deposit(amount);
				if (amount <= 0) {
					System.out.println("Can't deposit nonpositive amount.");
				}else {
            	   System.out.println("$" + amount + " has been deposited.");
            	}
				System.out.println("Current Balance: $"+ balance);
				//System.out.println("\n");   
				} catch (InputMismatchException e) {
				    //handle the error scenario where the input is a character
				    //System.err.println("Enter Valid Input");
				}
				break;
				
			case 'C':
				System.out.println("========================================");
				System.out.println("Enter the amount you want to withdraw:");
				System.out.println("========================================");
				try {
				double amount2 = scanner.nextDouble();
				withdrawal(amount2);
				if (amount2 <= 0 || amount2 > balance) {
					System.out.println("Withdrawal can't be completed.");
				}else {
					System.out.println("$" + amount2 + " has been withdrawn.");
					System.out.println("Current Balance: $"+ balance);
				}
				System.out.println("\n");
				} catch (InputMismatchException e) {
				    //handle the error scenario where the input is a character
				    //System.err.println("Enter Valid Input");
				}
				break;
				
			case 'D':
				System.out.println("========================================");
				getRecentTransaction();
				System.out.println("========================================");
				System.out.println("\n");
				break;
				
			case 'E':
				System.out.println("****************************************");
				System.out.println("Banking Application Has Been Closed");
				System.out.println("Thank You For Banking With Us!!!");
				scanner.close();
				System.exit(0);
				break;
				
			default:
				System.out.println("Option Invalid!!! Please enter valid option");
				break;
			
			}
		}while(option != 'E');
		
		//System.out.println("Thank You For Banking With Us!!!");
	}
}