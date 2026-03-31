import java.util.*;

class Account {
    String accountNumber, customerName;
    double balance;
    
    Account(String accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }
    
    public String toString() {
        return accountNumber + " - " + customerName + " ($" + String.format("%.2f", balance) + ")";
    }
}

class WithdrawalRequest {
    String accountNumber;
    double amount;
    
    WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
    
    public String toString() {
        return "Withdraw $" + amount + " from " + accountNumber;
    }
}

public class BankingSystem {
    HashMap<String, Account> accounts = new HashMap<>();
    Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();
    
    void createAccount(String accountNumber, String customerName, double initialBalance) {
        accounts.put(accountNumber, new Account(accountNumber, customerName, initialBalance));
        System.out.println("Account created: " + accountNumber);
    }
    
    void deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.balance += amount;
            System.out.println("Deposited $" + amount + " to " + accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }
    
    void requestWithdrawal(String accountNumber, double amount) {
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
        System.out.println("Withdrawal request queued: $" + amount + " from " + accountNumber);
    }
    
    void processWithdrawals() {
        System.out.println("\n=== Processing Withdrawal Requests ===");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            Account account = accounts.get(request.accountNumber);
            
            if (account != null) {
                if (account.balance >= request.amount) {
                    account.balance -= request.amount;
                    System.out.println("✓ Processed: " + request + " (New balance: $" + String.format("%.2f", account.balance) + ")");
                } else {
                    System.out.println("✗ Insufficient funds: " + request + " (Balance: $" + String.format("%.2f", account.balance) + ")");
                }
            } else {
                System.out.println("✗ Account not found: " + request);
            }
        }
    }
    
    void displayAccountsByBalance() {
        System.out.println("\n=== Accounts Sorted by Balance ===");
        TreeMap<Double, List<Account>> sortedByBalance = new TreeMap<>(Collections.reverseOrder());
        
        for (Account account : accounts.values()) {
            sortedByBalance.computeIfAbsent(account.balance, k -> new ArrayList<>()).add(account);
        }
        
        for (Map.Entry<Double, List<Account>> entry : sortedByBalance.entrySet()) {
            for (Account account : entry.getValue()) {
                System.out.println(account);
            }
        }
    }
    
    void displayAllAccounts() {
        System.out.println("\n=== All Accounts ===");
        for (Account account : accounts.values()) {
            System.out.println(account);
        }
    }
    
    void displayPendingWithdrawals() {
        System.out.println("\n=== Pending Withdrawal Requests ===");
        if (withdrawalQueue.isEmpty()) {
            System.out.println("No pending requests");
        } else {
            for (WithdrawalRequest request : withdrawalQueue) {
                System.out.println(request);
            }
        }
    }
    
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        
        // Create accounts
        bank.createAccount("ACC001", "John Doe", 5000.00);
        bank.createAccount("ACC002", "Jane Smith", 3000.00);
        bank.createAccount("ACC003", "Bob Johnson", 7500.00);
        bank.createAccount("ACC004", "Alice Brown", 2000.00);
        
        // Make deposits
        bank.deposit("ACC001", 1000.00);
        bank.deposit("ACC002", 500.00);
        
        // Request withdrawals
        bank.requestWithdrawal("ACC001", 2000.00);
        bank.requestWithdrawal("ACC002", 4000.00); // Insufficient funds
        bank.requestWithdrawal("ACC003", 1500.00);
        bank.requestWithdrawal("ACC999", 100.00);  // Non-existent account
        
        bank.displayAllAccounts();
        bank.displayAccountsByBalance();
        bank.displayPendingWithdrawals();
        
        // Process withdrawals
        bank.processWithdrawals();
        
        bank.displayAllAccounts();
        bank.displayAccountsByBalance();
    }
}