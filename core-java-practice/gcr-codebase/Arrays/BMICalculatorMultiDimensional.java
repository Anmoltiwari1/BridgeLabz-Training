import java.util.Scanner;

public class BMICalculatorMultiDimensional {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int number = scanner.nextInt();
        
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];
        
        System.out.println("Enter weight and height for each person:");
        for (int i = 0; i < number; i++) {
            System.out.print("Enter weight of person " + (i + 1) + " (in kg): ");
            personData[i][0] = scanner.nextDouble();
            while (personData[i][0] < 0) {
                System.out.print("Please enter positive weight: ");
                personData[i][0] = scanner.nextDouble();
            }
            
            System.out.print("Enter height of person " + (i + 1) + " (in meters): ");
            personData[i][1] = scanner.nextDouble();
            while (personData[i][1] < 0) {
                System.out.print("Please enter positive height: ");
                personData[i][1] = scanner.nextDouble();
            }
        }
        
        for (int i = 0; i < number; i++) {
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            
            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] >= 25.0 && personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        System.out.println("\nBMI Results:");
        System.out.println("Person\tWeight\tHeight\tBMI\tStatus");
        System.out.println("------\t------\t------\t---\t------");
        for (int i = 0; i < number; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n", 
                            (i + 1), personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
        
        scanner.close();
    }
}
