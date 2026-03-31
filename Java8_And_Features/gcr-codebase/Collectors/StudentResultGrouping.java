import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private String grade;
    
    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
    
    public String getName() { return name; }
    public String getGrade() { return grade; }
    
    @Override
    public String toString() {
        return name + "(" + grade + ")";
    }
}

public class StudentResultGrouping {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", "A"),
            new Student("Bob", "B"),
            new Student("Charlie", "A"),
            new Student("Diana", "C"),
            new Student("Eve", "B"),
            new Student("Frank", "A")
        );
        
        Map<String, List<String>> studentsByGrade = students.stream()
            .collect(Collectors.groupingBy(
                Student::getGrade,
                Collectors.mapping(Student::getName, Collectors.toList())
            ));
        
        System.out.println("Students grouped by grade:");
        studentsByGrade.forEach((grade, names) -> 
            System.out.println("Grade " + grade + ": " + names));
    }
}