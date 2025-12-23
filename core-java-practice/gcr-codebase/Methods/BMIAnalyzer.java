import java.util.Scanner;

public class BMIAnalyzer {
    public static void calculateBMI(double[][] personData) {
        for (int i = 0; i < personData.length; i++) {
            double weight = personData[i][0];
            double heightInCm = personData[i][1];
            double heightInM = heightInCm / 100;
            personData[i][2] = weight / (heightInM * heightInM);
        }
    }
    
    public static String[] determineBMIStatus(double[][] personData) {
        String[] status = new String[personData.length];
        for (int i = 0; i < personData.length; i++) {
            double bmi = personData[i][2];
            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] personData = new double[10][3];
        
        System.out.println("Enter weight and height for 10 persons:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight of person " + (i + 1) + " (in kg): ");
            personData[i][0] = scanner.nextDouble();
            System.out.print("Enter height of person " + (i + 1) + " (in cm): ");
            personData[i][1] = scanner.nextDouble();
        }
        
        calculateBMI(personData);
        String[] bmiStatus = determineBMIStatus(personData);
        
        System.out.println("\nBMI Results:");
        System.out.println("Person\tWeight(kg)\tHeight(cm)\tBMI\tStatus");
        System.out.println("------\t----------\t----------\t---\t------");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t%s%n", 
                            (i + 1), personData[i][0], personData[i][1], personData[i][2], bmiStatus[i]);
        }
        
        scanner.close();
    }
}
