package JavaOOP.Core.BankAccount;

import java.util.Random;

public class BankAccount {
    
    

    public static int accounts = 0;
    public static double totalMoney = 0;

        // Ninja Bonus (Solutions vary!)
    private static int generateId() {
		Random randGenerator = new Random();
        int randomId = randGenerator.nextInt(1000000000) + 999999999;
		return randomId;
	}

    // instance things (belonging to a particular bank account)
	private int accountNumber;

    private double checkingBalance;
    private double savingsBalance;

    //Constructor
	public BankAccount() {
		BankAccount.accounts += 1;
		this.checkingBalance = 0;
		this.savingsBalance = 0;
		this.accountNumber = BankAccount.generateId();
	}

    //Getters
    public double getChekingBalance(){
        return this.checkingBalance;
    }
    public double setSavingsBalance(){
        return this.savingsBalance;
    }

    public double getAccountNumber(){
        return this.accountNumber;
    }

    public double getTotalMoney(){
        return totalMoney;
    }

    //Methods
    public void depositMoney(double amount, String account) {
		if(account.equals("savings"))
			this.savingsBalance += amount;
		else if(account.equals("checking"))
			this.checkingBalance += amount;
		BankAccount.totalMoney += amount;
	}

    public void withdrawMoney(double amount, String account) {
		boolean successful = false;
		if(account.equals("savings")) {
			// check if enough in account
			if(this.savingsBalance - amount >= 0) {
				successful = true;
				this.savingsBalance -= amount;
			}
		}
		else if(account.equals("checking")) {
			// check if enough in account
			if(this.checkingBalance - amount >= 0) {
				successful = true;
				this.checkingBalance -= amount;
			}
		}
		if(successful) {
			BankAccount.totalMoney -= amount;
		}
        else {
            System.out.println("Insufficient funds.");
        }
	}


	public void displayAccountBalance() {
		System.out.println(String.format("Savings: %s, Checking: %s", this.savingsBalance, this.checkingBalance));
	}


}
