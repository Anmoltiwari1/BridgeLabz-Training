import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter marks in Physics: ");
        double physics = scanner.nextDouble();
        
        System.out.print("Enter marks in Chemistry: ");
        double chemistry = scanner.nextDouble();
        
        System.out.print("Enter marks in Maths: ");
        double maths = scanner.nextDouble();
        
        double totalMarks = physics + chemistry + maths;
        double percentage = (totalMarks / 300) * 100;
        
        char grade;
        String remarks;
        
        if (percentage >= 80) {
            grade = 'A';
            remarks = "(Level 4, above agency-normalized standards)";
        } else if (percentage >= 70) {
            grade = 'B';
            remarks = "(Level 3, at agency-normalized standards)";
        } else if (percentage >= 60) {
            grade = 'C';
            remarks = "(Level 2, below, but approaching agency-normalized standards)";
        } else if (percentage >= 50) {
            grade = 'D';
            remarks = "(Level 1, well below agency-normalized standards)";
        } else if (percentage >= 40) {
            grade = 'E';
            remarks = "(Level 1-, too below agency-normalized standards)";
        } else {
            grade = 'R';
            remarks = "(Remedial standards)";
        }
        
        System.out.println("\n--- Grade Report ---");
        System.out.println("Physics: " + physics);
        System.out.println("Chemistry: " + chemistry);
        System.out.println("Maths: " + maths);
        System.out.println("Total Marks: " + totalMarks + "/300");
        System.out.println("Average Mark: " + String.format("%.2f", percentage) + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
        
        scanner.close();
    }
}
