import java.util.Scanner;

public class NumberCheckerExtended {
    public static int findDigitCount(int number) {
        if (number == 0) return 1;
        int count = 0;
        number = Math.abs(number);
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }
    
    public static int[] storeDigits(int number) {
        int digitCount = findDigitCount(number);
        int[] digits = new int[digitCount];
        number = Math.abs(number);
        
        for (int i = digitCount - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }
    
    public static int findSumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
    
    public static double findSumOfSquares(int[] digits) {
        double sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }
    
    public static boolean isHarshadNumber(int[] digits) {
        int originalNumber = 0;
        for (int digit : digits) {
            originalNumber = originalNumber * 10 + digit;
        }
        
        int sumOfDigits = findSumOfDigits(digits);
        return originalNumber % sumOfDigits == 0;
    }
    
    public static int[][] findDigitFrequency(int[] digits) {
        int[] frequency = new int[10];
        
        for (int digit : digits) {
            frequency[digit]++;
        }
        
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                count++;
            }
        }
        
        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                result[index][0] = i;
                result[index][1] = frequency[i];
                index++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int[] digits = storeDigits(number);
        
        System.out.println("Number of digits: " + findDigitCount(number));
        
        System.out.print("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();
        
        System.out.println("Sum of digits: " + findSumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + findSumOfSquares(digits));
        System.out.println("Is Harshad Number: " + isHarshadNumber(digits));
        
        int[][] frequency = findDigitFrequency(digits);
        System.out.println("Digit Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println("Digit " + frequency[i][0] + ": " + frequency[i][1] + " times");
        }
        
        scanner.close();
    }
}
