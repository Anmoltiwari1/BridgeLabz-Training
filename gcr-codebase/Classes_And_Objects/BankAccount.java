//package Classes_And_Objects;

public class BankAccount {
    
    String accountHolder;
    String accountNumber;
    double balance;

    BankAccount( String accountHolder,String accountNumber,double balance){
        this.accountHolder=accountHolder;
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public static void BankDetails(){
        System.out.println("Unio Bank of India");
    }

    public void DepostingMoney(double money){
        if(money>0){
            balance+=money;
        }
        else{
            System.out.println("Value must be positive");
        }
    }

    public void WithDrawMoney(double money){
        if(money<=balance && money>0){
            balance=balance-money;
            System.out.println("Withdraw amount is : "+money);
        }else if(money<=0){
            System.out.println("Withdraw amount to be positive");
        }else{
            System.out.println("Insufficient balance");
        }
    }

    public void displayBalance(){
        System.out.println("Current Balance: "+balance);
    }


    public static void main(String[] args) {
       // Creating a BankAccount object
       BankAccount account = new BankAccount("Lynda", "123456789", 700.00);
      
       //Display the Bank name
       BankDetails();
      
       // Display initial balance
       account.displayBalance();
       // Deposit money
       account.DepostingMoney(200.00);
       account.displayBalance();
       // Withdraw money
       account.WithDrawMoney(100.00);
       account.displayBalance();
       // Try to withdraw more than the available balance
       account.WithDrawMoney(900.00);

    }
}
