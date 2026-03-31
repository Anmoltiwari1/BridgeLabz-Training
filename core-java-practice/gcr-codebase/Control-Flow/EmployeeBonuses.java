import java.util.Scanner;

public class EmployeeBonuses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter years of service: ");
        int yearsOfService = scanner.nextInt();
        
        double bonusAmount = 0.0;
        
        if (yearsOfService > 5) {
            bonusAmount = salary * 0.05;
        }
        
        System.out.println("Bonus amount: " + bonusAmount);
        
        scanner.close();
    }
}
