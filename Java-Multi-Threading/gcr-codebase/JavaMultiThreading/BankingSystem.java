import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class BankAccount {
    private double balance = 10000;
    
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            balance -= amount;
            return true;
        }
        return false;
    }
    
    public double getBalance() {
        return balance;
    }
}

class Transaction implements Runnable {
    private BankAccount account;
    private String customerName;
    private double amount;
    
    public Transaction(BankAccount account, String customerName, double amount) {
        this.account = account;
        this.customerName = customerName;
        this.amount = amount;
    }
    
    @Override
    public void run() {
        System.out.println("[" + customerName + "] Attempting to withdraw " + amount);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        
        if (account.withdraw(amount)) {
            System.out.println("Transaction successful: " + customerName + ", Amount: " + amount + 
                             ", Balance: " + account.getBalance() + " at " + timestamp);
        } else {
            System.out.println("Transaction failed: " + customerName + ", Amount: " + amount + 
                             ", Insufficient funds at " + timestamp);
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        
        Thread t1 = new Thread(new Transaction(account, "Customer-1", 3000), "Customer-1");
        Thread t2 = new Thread(new Transaction(account, "Customer-2", 4000), "Customer-2");
        Thread t3 = new Thread(new Transaction(account, "Customer-3", 2000), "Customer-3");
        Thread t4 = new Thread(new Transaction(account, "Customer-4", 5000), "Customer-4");
        Thread t5 = new Thread(new Transaction(account, "Customer-5", 1500), "Customer-5");
        
        System.out.println("Initial balance: " + account.getBalance());
        
        System.out.println("Thread states before processing:");
        System.out.println(t1.getName() + ": " + t1.getState());
        System.out.println(t2.getName() + ": " + t2.getState());
        System.out.println(t3.getName() + ": " + t3.getState());
        System.out.println(t4.getName() + ": " + t4.getState());
        System.out.println(t5.getName() + ": " + t5.getState());
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Final balance: " + account.getBalance());
    }
}