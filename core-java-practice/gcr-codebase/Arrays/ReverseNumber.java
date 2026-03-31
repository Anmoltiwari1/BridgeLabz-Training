import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int tempNumber = number;
        int digitCount = 0;
        
        while (tempNumber != 0) {
            digitCount++;
            tempNumber = tempNumber / 10;
        }
        
        int[] digits = new int[digitCount];
        tempNumber = number;
        
        for (int i = 0; i < digitCount; i++) {
            digits[i] = tempNumber % 10;
            tempNumber = tempNumber / 10;
        }
        
        int[] reversedDigits = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            reversedDigits[i] = digits[digitCount - 1 - i];
        }
        
        System.out.print("Original number: " + number);
        System.out.print("\nDigits in original order: ");
        for (int i = digitCount - 1; i >= 0; i--) {
            System.out.print(digits[i] + " ");
        }
        
        System.out.print("\nReversed number: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(reversedDigits[i]);
        }
        
        scanner.close();
    }
}
