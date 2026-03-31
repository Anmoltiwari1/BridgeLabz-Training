import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int tempNumber = Math.abs(number);
        int digitCount = 0;
        
        if (tempNumber == 0) {
            digitCount = 1;
        } else {
            int temp = tempNumber;
            while (temp != 0) {
                digitCount++;
                temp = temp / 10;
            }
        }
        
        int[] digits = new int[digitCount];
        tempNumber = Math.abs(number);
        
        if (tempNumber == 0) {
            digits[0] = 0;
        } else {
            for (int i = 0; i < digitCount; i++) {
                digits[i] = tempNumber % 10;
                tempNumber = tempNumber / 10;
            }
        }
        
        int[] frequency = new int[10];
        
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }
        
        System.out.print("Digits in the number: ");
        for (int i = digitCount - 1; i >= 0; i--) {
            System.out.print(digits[i] + " ");
        }
        
        System.out.println("\n\nFrequency of each digit:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " time(s)");
            }
        }
        
        scanner.close();
    }
}
