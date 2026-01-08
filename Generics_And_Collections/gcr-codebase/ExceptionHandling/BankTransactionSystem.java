class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;
    
    BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
    
    double getBalance() {
        return balance;
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        
        try {
            account.withdraw(500.0);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            account.withdraw(-100.0);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            account.withdraw(600.0);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}