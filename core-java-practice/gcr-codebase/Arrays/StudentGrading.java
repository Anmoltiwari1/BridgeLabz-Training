import java.util.Scanner;

public class StudentGrading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        int[][] marks = new int[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        char[] grades = new char[numberOfStudents];

        System.out.println("Enter marks for each student in Physics, Chemistry, and Maths:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = "";
                if (j == 0) subject = "Physics";
                else if (j == 1) subject = "Chemistry";
                else subject = "Maths";

                System.out.print("Enter " + subject + " marks: ");
                marks[i][j] = scanner.nextInt();
                while (marks[i][j] < 0) {
                    System.out.print("Please enter positive marks for " + subject + ": ");
                    marks[i][j] = scanner.nextInt();
                }
            }
        }

        for (int i = 0; i < numberOfStudents; i++) {
            int totalMarks = 0;
            for (int j = 0; j < 3; j++) {
                totalMarks += marks[i][j];
            }
            percentages[i] = (totalMarks / 3.0);

            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        System.out.println("\nStudent Results:");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        System.out.println("-------\t-------\t---------\t-----\t----------\t-----");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.2f%%\t\t%c%n",
                            (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }

        System.out.println("\nGrade Legend:");
        System.out.println("A: 80% and above (Level 4, above agency-normalized standards)");
        System.out.println("B: 70-79% (Level 3, at agency-normalized standards)");
        System.out.println("C: 60-69% (Level 2, below, but approaching agency-normalized standards)");
        System.out.println("D: 50-59% (Level 1, well below agency-normalized standards)");
        System.out.println("E: 40-49% (Level 1-, too below agency-normalized standards)");
        System.out.println("R: 39% and below (Remedial standards)");

        scanner.close();
    }
}
