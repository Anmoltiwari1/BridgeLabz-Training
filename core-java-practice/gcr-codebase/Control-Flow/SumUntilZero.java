import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double total = 0.0;
        double userInput;
        
        System.out.print("Enter a number (0 to stop): ");
        userInput = scanner.nextDouble();
        
        while (userInput != 0) {
            total += userInput;
            System.out.print("Enter a number (0 to stop): ");
            userInput = scanner.nextDouble();
        }
        
        System.out.println("Total sum: " + total);
        
        scanner.close();
    }
}
