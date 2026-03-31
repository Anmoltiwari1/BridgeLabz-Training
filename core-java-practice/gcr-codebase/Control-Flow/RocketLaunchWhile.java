import java.util.Scanner;

public class RocketLaunchWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter countdown value: ");
        int counter = scanner.nextInt();
        
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
        
        System.out.println("Rocket Launch!");
        
        scanner.close();
    }
}
