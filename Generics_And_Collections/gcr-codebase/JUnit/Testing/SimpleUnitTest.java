class Program {
    private double balance;
    
    public Program(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        balance += amount;
    }
    
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
    }
}

public class SimpleUnitTest {
    
    public static void main(String[] args) {
        SimpleUnitTest test = new SimpleUnitTest();
        
        try {
            test.Test_Deposit_ValidAmount();
            System.out.println("✅ Test_Deposit_ValidAmount passed");
        } catch (Exception e) {
            System.out.println("❌ Test_Deposit_ValidAmount failed: " + e.getMessage());
        }
        
        try {
            test.Test_Deposit_NegativeAmount();
            System.out.println("✅ Test_Deposit_NegativeAmount passed");
        } catch (Exception e) {
            System.out.println("❌ Test_Deposit_NegativeAmount failed: " + e.getMessage());
        }
        
        try {
            test.Test_Withdraw_ValidAmount();
            System.out.println("✅ Test_Withdraw_ValidAmount passed");
        } catch (Exception e) {
            System.out.println("❌ Test_Withdraw_ValidAmount failed: " + e.getMessage());
        }
        
        try {
            test.Test_Withdraw_InsufficientFunds();
            System.out.println("✅ Test_Withdraw_InsufficientFunds passed");
        } catch (Exception e) {
            System.out.println("❌ Test_Withdraw_InsufficientFunds failed: " + e.getMessage());
        }
    }
    
    public void Test_Deposit_ValidAmount() {
        Program account = new Program(100.0);
        account.deposit(50.0);
        
        double expected = 150.0;
        double actual = account.getBalance();
        
        if (Math.abs(actual - expected) > 0.001) {
            throw new AssertionError("Expected: " + expected + ", but was: " + actual);
        }
    }
    
    public void Test_Deposit_NegativeAmount() {
        Program account = new Program(100.0);
        
        try {
            account.deposit(-50.0);
            throw new AssertionError("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            String expected = "Deposit amount cannot be negative";
            String actual = e.getMessage();
            
            if (!actual.equals(expected)) {
                throw new AssertionError("Expected: " + expected + ", but was: " + actual);
            }
        }
    }
    
    public void Test_Withdraw_ValidAmount() {
        Program account = new Program(100.0);
        account.withdraw(30.0);
        
        double expected = 70.0;
        double actual = account.getBalance();
        
        if (Math.abs(actual - expected) > 0.001) {
            throw new AssertionError("Expected: " + expected + ", but was: " + actual);
        }
    }
    
    public void Test_Withdraw_InsufficientFunds() {
        Program account = new Program(50.0);
        
        try {
            account.withdraw(100.0);
            throw new AssertionError("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            String expected = "Insufficient funds.";
            String actual = e.getMessage();
            
            if (!actual.equals(expected)) {
                throw new AssertionError("Expected: " + expected + ", but was: " + actual);
            }
        }
    }
}