import java.util.*;
class Customer{
	String name;
	int ID;
	
	Customer(String name, int ID){
		this.name = name;
		this.ID = ID;
	}
	
	void Balance(Bank b) {
		System.out.println("Balance is: " + b.bal.get(this));
	}
}
class Bank{
	String name;
	ArrayList <Customer> cus = new ArrayList<>();
	HashMap<Customer, Integer> accn = new HashMap<>();
	HashMap<Customer, Integer> bal = new HashMap<>();
	
	Bank(String name){
		this.name= name;
	}
	
	void Open(Customer c, int a, int b){
		cus.add(c);
		accn.put(c, a);
		bal.put(c, b);
	}
	
	void Details() {
		System.out.println("Accounts " + name);
		for(int i = 0; i < cus.size(); i++) {
			Customer c = cus.get(i);
			System.out.println("Customer Name: " + c.name + " | ID: " + c.ID + " | Account Number: " + accn.get(c) + " | Balance: " + bal.get(c));
		}
	}
}

public class BankAndAccountHolders {
	public static void main(String[] args) {
		Customer c1 = new Customer("Amit", 101);
		Customer c2 = new Customer("Atul", 102);
		Bank b1 = new Bank("HDFC Bank");
		Bank b2 = new Bank("ICICI Bank");
		b1.Open(c1, 123456, 10000);
		b1.Open(c2, 224456, 25000);
		b1.Details();
		b2.Open(c2, 234456, 2000);
		b2.Details();
		c1.Balance(b1);
		c2.Balance(b2);
	}
}
