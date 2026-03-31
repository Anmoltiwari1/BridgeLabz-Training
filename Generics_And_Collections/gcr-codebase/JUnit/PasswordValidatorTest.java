public class PasswordValidatorTest {
    public static void main(String[] args) {
        testValidPassword();
        testInvalidPassword();
        System.out.println("All PasswordValidator tests passed!");
    }
    
    static void testValidPassword() {
        PasswordValidator validator = new PasswordValidator();
        String[] validPasswords = {"Password1", "MySecret123", "HelloWorld9"};
        
        for (String password : validPasswords) {
            if (validator.isValidPassword(password)) {
                System.out.println("✅ Valid password test passed: " + password);
            } else {
                System.out.println("❌ Valid password test failed: " + password);
            }
        }
    }
    
    static void testInvalidPassword() {
        PasswordValidator validator = new PasswordValidator();
        String[] invalidPasswords = {"short", "nouppercase1", "NODIGITS", "NoDigit"};
        
        for (String password : invalidPasswords) {
            if (!validator.isValidPassword(password)) {
                System.out.println("✅ Invalid password test passed: " + password);
            } else {
                System.out.println("❌ Invalid password test failed: " + password);
            }
        }
    }
}