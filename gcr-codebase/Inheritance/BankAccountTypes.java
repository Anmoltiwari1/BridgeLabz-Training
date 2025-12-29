class BankAccount{
	int accountNumber;
	int balance;
	
	BankAccount(int accountNumber, int balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	void Display() {
		System.out.print("Account Number: " + accountNumber + " Balance: " + balance);
	}
}

class SavingsAccount extends BankAccount{
	double interestRate;
	
	SavingsAccount(int accountNumber, int balance, double interestRate){
		super(accountNumber, balance);
		this.interestRate = interestRate;
	}
	
	void DisplayType() {
		System.out.println("Account Type: Savings Account");
	}
	
	void Display() {
		super.Display();
		System.out.print(" Interest Rate (%): " + interestRate);
	}
}

class CheckingAccount extends BankAccount {
	int withdrawalLimit;
	
	CheckingAccount(int accountNumber, int balance, int withdrawalLimit){
		super(accountNumber, balance);
		this.withdrawalLimit = withdrawalLimit;
	}
	
	void DisplayType() {
		System.out.println("Account Type: Checking Account");
	}
	
	void Display() {
		super.Display();
		System.out.print(" Withdrawal Limit: " + withdrawalLimit);
	}
	
}

class FixedDepositAccount extends BankAccount{
	
	FixedDepositAccount(int accountNumber, int balance){
		super(accountNumber, balance);
	}
	
	void DisplayType() {
		System.out.println("Account Type: Fixed Deposit Account");
	}
	
	void Display() {
		super.Display();
	}
}

public class BankAccountTypes {
	public static void main(String[] args) {
		SavingsAccount s1 = new SavingsAccount(684115325, 12000, 10.5);
		CheckingAccount c1 = new CheckingAccount(484522532, 20000, 10000);
		FixedDepositAccount f1 = new FixedDepositAccount(789521532, 25000);
		s1.DisplayType();
		s1.Display();
		System.out.println();
		c1.DisplayType();
		c1.Display();
		System.out.println();
		f1.DisplayType();
		f1.Display();
		System.out.println();
	}
}
