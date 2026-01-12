public class DatabaseConnectionTest {
    private DatabaseConnection db;
    
    public static void main(String[] args) {
        DatabaseConnectionTest test = new DatabaseConnectionTest();
        test.runTests();
    }
    
    void runTests() {
        testConnection();
        testDisconnection();
        System.out.println("All DatabaseConnection tests passed!");
    }
    
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }
    
    void tearDown() {
        db.disconnect();
    }
    
    void testConnection() {
        setUp();
        if (db.isConnected()) {
            System.out.println("✅ testConnection passed");
        } else {
            System.out.println("❌ testConnection failed");
        }
        tearDown();
    }
    
    void testDisconnection() {
        setUp();
        db.disconnect();
        if (!db.isConnected()) {
            System.out.println("✅ testDisconnection passed");
        } else {
            System.out.println("❌ testDisconnection failed");
        }
    }
}