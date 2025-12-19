import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int sum = 0;
        int tempNumber = number;
        
        while (tempNumber != 0) {
            int digit = tempNumber % 10;
            sum = sum + digit;
            tempNumber = tempNumber / 10;
        }
        
        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number");
        } else {
            System.out.println(number + " is not a Harshad Number");
        }
        
        scanner.close();
    }
}
