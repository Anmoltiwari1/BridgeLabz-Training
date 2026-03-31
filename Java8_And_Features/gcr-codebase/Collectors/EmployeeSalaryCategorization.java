import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;
    
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return name + " (" + department + "): $" + salary;
    }
}

public class EmployeeSalaryCategorization {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "Engineering", 95000),
            new Employee("Bob", "Engineering", 87000),
            new Employee("Charlie", "Marketing", 65000),
            new Employee("Diana", "HR", 58000),
            new Employee("Eve", "Engineering", 92000),
            new Employee("Frank", "Marketing", 72000),
            new Employee("Grace", "HR", 62000),
            new Employee("Henry", "Finance", 78000),
            new Employee("Ivy", "Finance", 85000)
        );
        
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));
        
        System.out.println("Average salary by department:");
        avgSalaryByDept.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry -> 
                System.out.printf("%s: $%.2f%n", entry.getKey(), entry.getValue()));
        
        Map<String, List<Employee>> employeesByDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));
        
        System.out.println("\nEmployees by department:");
        employeesByDept.forEach((dept, empList) -> {
            System.out.println(dept + ":");
            empList.forEach(emp -> System.out.println("  " + emp.getName() + ": $" + emp.getSalary()));
        });
    }
}