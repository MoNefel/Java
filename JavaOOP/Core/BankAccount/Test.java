package JavaOOP.Core.BankAccount;

public class Test {
    public static void main(String[] args) {

        BankAccount bank = new BankAccount();
        System.out.println("New Acc No. - " + bank.getAccountNumber());
		bank.depositMoney(100.49, "checking");
		bank.depositMoney(3.00, "savings");
		bank.displayAccountBalance();

		System.out.println(BankAccount.totalMoney);

		bank.withdrawMoney(50, "checking");
		bank.withdrawMoney(50, "savings");
		bank.displayAccountBalance();

		System.out.println(BankAccount.totalMoney);

        BankAccount bank2 = new BankAccount();
        System.out.println("New Acc No. - " + bank2.getAccountNumber());
		bank2.depositMoney(3, "checking");
		bank2.depositMoney(99, "savings");
		bank2.displayAccountBalance();
        bank2.withdrawMoney(50, "checking");
        
    }
    
}
