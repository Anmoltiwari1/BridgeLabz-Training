import java.util.Scanner;

public class StudentScorecard {
    public static int[][] generateRandomScores(int numberOfStudents) {
        int[][] scores = new int[numberOfStudents][3];
        
        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = (int) (Math.random() * 90) + 10;
            scores[i][1] = (int) (Math.random() * 90) + 10;
            scores[i][2] = (int) (Math.random() * 90) + 10;
        }
        
        return scores;
    }
    
    public static double[][] calculateTotalAveragePercentage(int[][] scores) {
        int numberOfStudents = scores.length;
        double[][] results = new double[numberOfStudents][3];
        
        for (int i = 0; i < numberOfStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            
            results[i][0] = Math.round(total * 100.0) / 100.0;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        
        return results;
    }
    
    public static char determineGrade(double percentage) {
        if (percentage >= 80) {
            return 'A';
        } else if (percentage >= 70) {
            return 'B';
        } else if (percentage >= 60) {
            return 'C';
        } else if (percentage >= 50) {
            return 'D';
        } else if (percentage >= 40) {
            return 'E';
        } else {
            return 'R';
        }
    }
    
    public static String getGradeRemarks(char grade) {
        switch (grade) {
            case 'A': return "Level 4, above agency-normalized standards";
            case 'B': return "Level 3, at agency-normalized standards";
            case 'C': return "Level 2, below, but approaching agency-normalized standards";
            case 'D': return "Level 1, well below agency-normalized standards";
            case 'E': return "Level 1-, too below agency-normalized standards";
            case 'R': return "Remedial standards";
            default: return "Unknown";
        }
    }
    
    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("\nSTUDENT SCORECARD");
        System.out.println("=================");
        System.out.println();
        
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade\tRemarks");
        System.out.println("-------\t-------\t---------\t-----\t-----\t-------\t----------\t-----\t-------");
        
        for (int i = 0; i < scores.length; i++) {
            char grade = determineGrade(results[i][2]);
            String remarks = getGradeRemarks(grade);
            
            System.out.printf("%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f%%\t\t%c\t%s%n",
                            (i + 1), scores[i][0], scores[i][1], scores[i][2],
                            results[i][0], results[i][1], results[i][2], grade, remarks);
        }
        
        System.out.println();
        displayGradingSystem();
        displayStatistics(scores, results);
    }
    
    public static void displayGradingSystem() {
        System.out.println("GRADING SYSTEM:");
        System.out.println("===============");
        System.out.println("Grade\tMarks\t\tRemarks");
        System.out.println("-----\t-----\t\t-------");
        System.out.println("A\t80% and above\t(Level 4, above agency-normalized standards)");
        System.out.println("B\t70-79%\t\t(Level 3, at agency-normalized standards)");
        System.out.println("C\t60-69%\t\t(Level 2, below, but approaching agency-normalized standards)");
        System.out.println("D\t50-59%\t\t(Level 1, well below agency-normalized standards)");
        System.out.println("E\t40-49%\t\t(Level 1-, too below agency-normalized standards)");
        System.out.println("R\t39% and below\t(Remedial standards)");
        System.out.println();
    }
    
    public static void displayStatistics(int[][] scores, double[][] results) {
        int[] gradeCount = new int[6];
        double totalPercentage = 0;
        double highestPercentage = 0;
        double lowestPercentage = 100;
        
        for (int i = 0; i < results.length; i++) {
            double percentage = results[i][2];
            totalPercentage += percentage;
            
            if (percentage > highestPercentage) {
                highestPercentage = percentage;
            }
            if (percentage < lowestPercentage) {
                lowestPercentage = percentage;
            }
            
            char grade = determineGrade(percentage);
            switch (grade) {
                case 'A': gradeCount[0]++; break;
                case 'B': gradeCount[1]++; break;
                case 'C': gradeCount[2]++; break;
                case 'D': gradeCount[3]++; break;
                case 'E': gradeCount[4]++; break;
                case 'R': gradeCount[5]++; break;
            }
        }
        
        double classAverage = totalPercentage / results.length;
        
        System.out.println("CLASS STATISTICS:");
        System.out.println("=================");
        System.out.printf("Class Average: %.2f%%%n", classAverage);
        System.out.printf("Highest Percentage: %.2f%%%n", highestPercentage);
        System.out.printf("Lowest Percentage: %.2f%%%n", lowestPercentage);
        System.out.println();
        
        System.out.println("Grade Distribution:");
        char[] grades = {'A', 'B', 'C', 'D', 'E', 'R'};
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Grade " + grades[i] + ": " + gradeCount[i] + " students");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("STUDENT MARKS CALCULATOR");
        System.out.println("========================");
        System.out.println();
        
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students. Please enter a positive number.");
            return;
        }
        
        int[][] scores = generateRandomScores(numberOfStudents);
        double[][] results = calculateTotalAveragePercentage(scores);
        
        displayScorecard(scores, results);
        
        scanner.close();
    }
}
