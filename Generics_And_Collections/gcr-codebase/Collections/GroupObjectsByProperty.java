import java.util.*;

class Employee {
    String name, department;
    
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    
    public String toString() {
        return name;
    }
}

public class GroupObjectsByProperty {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR"),
            new Employee("Dave", "IT"),
            new Employee("Eve", "Finance")
        );
        
        Map<String, List<Employee>> grouped = groupByDepartment(employees);
        
        System.out.println("Employees grouped by department:");
        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        
        for (Employee emp : employees) {
            grouped.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }
        
        return grouped;
    }
}