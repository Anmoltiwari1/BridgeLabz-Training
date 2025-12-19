import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter weight in kg: ");
        double weight = scanner.nextDouble();
        
        System.out.print("Enter height in cm: ");
        double height = scanner.nextDouble();
        
        double heightInMeters = height / 100;
        double bmi = weight / (heightInMeters * heightInMeters);
        
        System.out.println("BMI: " + String.format("%.2f", bmi));
        
        if (bmi <= 18.4) {
            System.out.println("Status: Underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Status: Normal");
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            System.out.println("Status: Overweight");
        } else if (bmi >= 40.0) {
            System.out.println("Status: Obese");
        }
        
        scanner.close();
    }
}
