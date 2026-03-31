import java.util.Scanner;

public class RocketLaunchFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter countdown value: ");
        int counter = scanner.nextInt();
        
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
        
        System.out.println("Rocket Launch!");
        
        scanner.close();
    }
}
