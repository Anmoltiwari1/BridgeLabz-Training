import java.io.*;
import java.util.*;

class Student {
    private String name;
    private int age;
    private String email;
    
    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}

public class CSVToObjects {
    public static List<Student> readStudentsFromCSV(String filename) {
        List<Student> students = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String name = data[0].trim();
                    int age = Integer.parseInt(data[1].trim());
                    String email = data[2].trim();
                    
                    students.add(new Student(name, age, email));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
        
        return students;
    }
    
    public static void main(String[] args) {
        // Create sample CSV file
        try (PrintWriter pw = new PrintWriter("students.csv")) {
            pw.println("Name,Age,Email");
            pw.println("Alice,20,alice@email.com");
            pw.println("Bob,22,bob@email.com");
            pw.println("Charlie,21,charlie@email.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        List<Student> students = readStudentsFromCSV("students.csv");
        
        System.out.println("Students from CSV:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}