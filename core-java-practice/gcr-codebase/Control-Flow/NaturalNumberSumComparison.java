import java.util.Scanner;

public class NaturalNumberSumComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("The number " + n + " is not a natural number");
        } else {
            int formulaSum = n * (n + 1) / 2;
            
            int loopSum = 0;
            int i = 1;
            while (i <= n) {
                loopSum += i;
                i++;
            }
            
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using while loop: " + loopSum);
            
            if (formulaSum == loopSum) {
                System.out.println("Both computations are correct and match!");
            } else {
                System.out.println("Results do not match!");
            }
        }
        
        scanner.close();
    }
}
