import java.util.Scanner;

public class SSNValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter SSN:");
        String ssn = sc.nextLine();
        
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        
        if (ssn.matches(regex)) {
            System.out.println("✅ \"" + ssn + "\" is valid");
        } else {
            System.out.println("❌ \"" + ssn + "\" is invalid");
        }
    }
}