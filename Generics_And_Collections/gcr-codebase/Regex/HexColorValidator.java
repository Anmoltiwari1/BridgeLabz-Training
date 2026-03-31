import java.util.Scanner;

public class HexColorValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter hex color code:");
        String color = sc.nextLine();
        
        String regex = "^#[0-9A-Fa-f]{6}$";
        
        if (color.matches(regex)) {
            System.out.println("✅ \"" + color + "\" → Valid");
        } else {
            System.out.println("❌ \"" + color + "\" → Invalid");
        }
    }
}