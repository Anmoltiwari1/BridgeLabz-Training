import java.util.Scanner;

public class IPValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter IP address:");
        String ip = sc.nextLine();
        
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        
        if (ip.matches(regex)) {
            System.out.println("✅ Valid IP address");
        } else {
            System.out.println("❌ Invalid IP address");
        }
    }
}