import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] multiplicationTable = new int[10];
        
        System.out.print("Enter a number to generate its multiplication table: ");
        int number = scanner.nextInt();
        
        for (int i = 1; i <= 10; i++) {
            multiplicationTable[i - 1] = number * i;
        }
        
        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 0; i < multiplicationTable.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationTable[i]);
        }
        
        scanner.close();
    }
}
