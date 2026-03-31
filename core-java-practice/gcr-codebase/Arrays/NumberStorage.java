import java.util.Scanner;

public class NumberStorage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        System.out.println("Enter numbers (maximum 10). Enter 0 or negative number to stop:");
        
        while (true) {
            System.out.print("Enter number " + (index + 1) + ": ");
            double number = scanner.nextDouble();
            
            if (number <= 0) {
                break;
            }
            
            if (index == 10) {
                break;
            }
            
            numbers[index] = number;
            index++;
        }
        
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }
        
        System.out.println("\nSum of all numbers: " + total);
        
        scanner.close();
    }
}
