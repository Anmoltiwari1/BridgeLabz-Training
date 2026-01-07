import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;
    
    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Dept: " + department + ", Salary: " + salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "John", "IT", 50000),
            new Employee(2, "Alice", "HR", 45000),
            new Employee(3, "Bob", "Finance", 55000)
        );
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            List<Employee> loadedEmployees = (List<Employee>) ois.readObject();
            System.out.println("Loaded employees:");
            for (Employee emp : loadedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}