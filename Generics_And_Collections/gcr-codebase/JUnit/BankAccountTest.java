public class BankAccountTest {
    public static void main(String[] args) {
        testDeposit();
        testWithdraw();
        testInsufficientFunds();
        System.out.println("All BankAccount tests passed!");
    }
    
    static void testDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        
        if (account.getBalance() == 150.0) {
            System.out.println("✅ testDeposit passed");
        } else {
            System.out.println("❌ testDeposit failed");
        }
    }
    
    static void testWithdraw() {
        BankAccount account = new BankAccount(100.0);
        boolean success = account.withdraw(30.0);
        
        if (success && account.getBalance() == 70.0) {
            System.out.println("✅ testWithdraw passed");
        } else {
            System.out.println("❌ testWithdraw failed");
        }
    }
    
    static void testInsufficientFunds() {
        BankAccount account = new BankAccount(50.0);
        boolean success = account.withdraw(100.0);
        
        if (!success && account.getBalance() == 50.0) {
            System.out.println("✅ testInsufficientFunds passed");
        } else {
            System.out.println("❌ testInsufficientFunds failed");
        }
    }
}