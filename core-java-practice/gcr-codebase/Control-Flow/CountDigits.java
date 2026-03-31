import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int count = 0;
        int tempNumber = number;
        
        if (number == 0) {
            count = 1;
        } else {
            if (number < 0) {
                tempNumber = -number;
            }
            
            while (tempNumber != 0) {
                tempNumber = tempNumber / 10;
                count++;
            }
        }
        
        System.out.println("Number of digits in " + number + " is: " + count);
        
        scanner.close();
    }
}
