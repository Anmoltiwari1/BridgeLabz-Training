public class UserRegistrationTest {
    public static void main(String[] args) {
        testValidRegistration();
        testInvalidUsername();
        testInvalidEmail();
        testInvalidPassword();
        System.out.println("All UserRegistration tests completed!");
    }
    
    static void testValidRegistration() {
        UserRegistration registration = new UserRegistration();
        
        try {
            boolean result = registration.registerUser("john_doe", "john@example.com", "password123");
            if (result) {
                System.out.println("✅ testValidRegistration passed");
            } else {
                System.out.println("❌ testValidRegistration failed");
            }
        } catch (Exception e) {
            System.out.println("❌ testValidRegistration failed: " + e.getMessage());
        }
    }
    
    static void testInvalidUsername() {
        UserRegistration registration = new UserRegistration();
        
        try {
            registration.registerUser("", "john@example.com", "password123");
            System.out.println("❌ testInvalidUsername failed - no exception thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ testInvalidUsername passed - exception caught: " + e.getMessage());
        }
    }
    
    static void testInvalidEmail() {
        UserRegistration registration = new UserRegistration();
        
        try {
            registration.registerUser("john_doe", "invalid-email", "password123");
            System.out.println("❌ testInvalidEmail failed - no exception thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ testInvalidEmail passed - exception caught: " + e.getMessage());
        }
    }
    
    static void testInvalidPassword() {
        UserRegistration registration = new UserRegistration();
        
        try {
            registration.registerUser("john_doe", "john@example.com", "123");
            System.out.println("❌ testInvalidPassword failed - no exception thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ testInvalidPassword passed - exception caught: " + e.getMessage());
        }
    }
}