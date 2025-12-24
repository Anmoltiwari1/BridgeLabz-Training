package BankAccountManagement;

public class SavingAccount extends BankAccount{

    SavingAccount(long accountNumber,String accountHolder,double balance){
        super(accountNumber,accountHolder,balance);
    }

     public void showDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
    }
}
