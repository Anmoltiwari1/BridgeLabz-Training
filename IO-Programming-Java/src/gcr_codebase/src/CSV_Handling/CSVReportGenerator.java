import java.io.*;
import java.util.*;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class CSVReportGenerator {
    // Simulate database records
    private static List<Employee> getEmployeesFromDatabase() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "Engineering", 75000));
        employees.add(new Employee(2, "Jane Smith", "Marketing", 65000));
        employees.add(new Employee(3, "Bob Johnson", "Engineering", 80000));
        employees.add(new Employee(4, "Alice Brown", "HR", 60000));
        employees.add(new Employee(5, "Charlie Wilson", "Finance", 70000));
        return employees;
    }
    
    public static void generateCSVReport(String filename) {
        List<Employee> employees = getEmployeesFromDatabase();
        
        try (PrintWriter pw = new PrintWriter(filename)) {
            // Write header
            pw.println("Employee ID,Name,Department,Salary");
            
            // Write employee data
            for (Employee emp : employees) {
                pw.println(emp.getId() + "," + emp.getName() + "," + 
                          emp.getDepartment() + "," + emp.getSalary());
            }
            
            System.out.println("CSV report generated successfully: " + filename);
            System.out.println("Total employees: " + employees.size());
            
        } catch (IOException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        generateCSVReport("employee_report.csv");
        
        // Display the generated report
        System.out.println("\n=== Generated Report ===");
        try (BufferedReader br = new BufferedReader(new FileReader("employee_report.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading report: " + e.getMessage());
        }
    }
}