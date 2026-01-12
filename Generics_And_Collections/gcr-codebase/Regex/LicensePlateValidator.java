import java.util.Scanner;

public class LicensePlateValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter license plate:");
        String plate = sc.nextLine();
        
        String regex = "^[A-Z]{2}\\d{4}$";
        
        if (plate.matches(regex)) {
            System.out.println("✅ \"" + plate + "\" → Valid");
        } else {
            System.out.println("❌ \"" + plate + "\" → Invalid");
        }
    }
}