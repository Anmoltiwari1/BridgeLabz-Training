import java.util.Scanner;

public class StudentGradingSystem {

    static final int MISSING = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] names = new String[students];
        String[] ids = new String[students];
        double[][] grades = new double[students][subjects];

        // Input student details and grades
        for (int i = 0; i < students; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Name: ");
            names[i] = sc.nextLine();

            System.out.print("ID: ");
            ids[i] = sc.nextLine();

            for (int j = 0; j < subjects; j++) {
                grades[i][j] = readGrade(sc, i, j);
            }
        }

        // Per student total & average
        System.out.println("\n--- Student Results ---");
        for (int i = 0; i < students; i++) {
            double total = 0;
            int count = 0;
            boolean incomplete = false;

            for (int j = 0; j < subjects; j++) {
                if (grades[i][j] == MISSING) {
                    incomplete = true;
                } else {
                    total += grades[i][j];
                    count++;
                }
            }

            System.out.print(names[i] + " (" + ids[i] + ") : ");

            if (count == 0) {
                System.out.println("No valid grades");
            } else {
                double avg = total / count;
                System.out.print("Total = " + total + ", Average = " + avg);
                if (incomplete) System.out.print(" (INCOMPLETE)");
                System.out.println();
            }
        }

        // Highest grade per subject
        System.out.println("\n--- Highest Grade Per Subject ---");
        for (int j = 0; j < subjects; j++) {
            double max = -1;
            for (int i = 0; i < students; i++) {
                if (grades[i][j] != MISSING && grades[i][j] > max) {
                    max = grades[i][j];
                }
            }
            System.out.println("Subject " + (j + 1) + ": " + (max == -1 ? "No data" : max));
        }

        // Overall class average
        double sum = 0;
        int totalGrades = 0;

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < subjects; j++) {
                if (grades[i][j] != MISSING) {
                    sum += grades[i][j];
                    totalGrades++;
                }
            }
        }

        System.out.println("\nOverall Class Average: " +
                (totalGrades == 0 ? "No data" : sum / totalGrades));
    }

    // Grade input with validation + exception handling
    private static double readGrade(Scanner sc, int student, int subject) {
        while (true) {
            try {
                System.out.print("Grade for subject " + (subject + 1) + " (-1 if missing): ");
                double g = sc.nextDouble();

                if (g == MISSING) return MISSING;
                if (g < 0 || g > 100) {
                    throw new IllegalArgumentException("Grade must be between 0 and 100");
                }
                return g;

            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                sc.nextLine(); // clear buffer
            }
        }
    }
}
