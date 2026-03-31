import java.util.Scanner;

public class NaturalNumberSumForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("The number " + n + " is not a natural number");
        } else {
            int formulaSum = n * (n + 1) / 2;
            
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }
            
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using for loop: " + loopSum);
            
            if (formulaSum == loopSum) {
                System.out.println("Both computations are correct and match!");
            } else {
                System.out.println("Results do not match!");
            }
        }
        
        scanner.close();
    }
}
