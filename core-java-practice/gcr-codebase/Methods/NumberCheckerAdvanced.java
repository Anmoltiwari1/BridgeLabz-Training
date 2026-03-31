import java.util.Scanner;

public class NumberCheckerAdvanced {
    public static int findSumOfProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
    
    public static boolean isPerfectNumber(int number) {
        if (number <= 1) return false;
        return findSumOfProperDivisors(number) == number;
    }
    
    public static boolean isAbundantNumber(int number) {
        if (number <= 1) return false;
        return findSumOfProperDivisors(number) > number;
    }
    
    public static boolean isDeficientNumber(int number) {
        if (number <= 1) return false;
        return findSumOfProperDivisors(number) < number;
    }
    
    public static int findFactorial(int n) {
        if (n <= 1) return 1;
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
    
    public static boolean isStrongNumber(int number) {
        int sum = 0;
        int temp = Math.abs(number);
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += findFactorial(digit);
            temp /= 10;
        }
        
        return sum == number;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int sumOfDivisors = findSumOfProperDivisors(number);
        
        System.out.println("Sum of proper divisors: " + sumOfDivisors);
        System.out.println("Is Perfect Number: " + isPerfectNumber(number));
        System.out.println("Is Abundant Number: " + isAbundantNumber(number));
        System.out.println("Is Deficient Number: " + isDeficientNumber(number));
        System.out.println("Is Strong Number: " + isStrongNumber(number));
        
        scanner.close();
    }
}
