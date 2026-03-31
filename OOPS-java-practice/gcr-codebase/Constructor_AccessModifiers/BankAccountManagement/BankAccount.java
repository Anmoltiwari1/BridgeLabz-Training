package BankAccountManagement;

public class BankAccount {
    
    public long accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(long accountNumber,String accountHolder,double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }

    public void Setbalance(double newbalance){
        balance=newbalance;
    }

    public double GetBalance(){
        return balance;
    }
}
