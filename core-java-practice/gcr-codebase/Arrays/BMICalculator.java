import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int numberOfPersons = scanner.nextInt();
        
        double[] weight = new double[numberOfPersons];
        double[] height = new double[numberOfPersons];
        double[] bmi = new double[numberOfPersons];
        String[] weightStatus = new String[numberOfPersons];
        
        System.out.println("Enter weight and height for each person:");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.print("Enter weight of person " + (i + 1) + " (in kg): ");
            weight[i] = scanner.nextDouble();
            System.out.print("Enter height of person " + (i + 1) + " (in meters): ");
            height[i] = scanner.nextDouble();
        }
        
        for (int i = 0; i < numberOfPersons; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);
            
            if (bmi[i] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi[i] >= 18.5 && bmi[i] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi[i] >= 25.0 && bmi[i] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        System.out.println("\nBMI Results:");
        System.out.println("Person\tHeight\tWeight\tBMI\tStatus");
        System.out.println("------\t------\t------\t---\t------");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n", 
                            (i + 1), height[i], weight[i], bmi[i], weightStatus[i]);
        }
        
        scanner.close();
    }
}
