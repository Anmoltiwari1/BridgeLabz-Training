import java.io.*;
import java.util.*;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private String joinDate;
    
    public Employee(int id, String name, String department, double salary, String joinDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
    }
    
    public String toJSON() {
        return "    {\n" +
               "      \"id\": " + id + ",\n" +
               "      \"name\": \"" + name + "\",\n" +
               "      \"department\": \"" + department + "\",\n" +
               "      \"salary\": " + salary + ",\n" +
               "      \"joinDate\": \"" + joinDate + "\"\n" +
               "    }";
    }
}

public class DatabaseToJSON {
    // Simulate database records
    private static List<Employee> getEmployeesFromDatabase() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "Engineering", 75000, "2020-01-15"));
        employees.add(new Employee(2, "Jane Smith", "Marketing", 65000, "2019-03-20"));
        employees.add(new Employee(3, "Bob Johnson", "Engineering", 80000, "2021-06-10"));
        employees.add(new Employee(4, "Alice Brown", "HR", 60000, "2018-11-05"));
        employees.add(new Employee(5, "Charlie Wilson", "Finance", 70000, "2020-09-12"));
        return employees;
    }
    
    public static void generateJSONReport(String filename) {
        List<Employee> employees = getEmployeesFromDatabase();
        
        try (PrintWriter pw = new PrintWriter(filename)) {
            pw.println("{");
            pw.println("  \"report\": {");
            pw.println("    \"title\": \"Employee Database Report\",");
            pw.println("    \"generatedDate\": \"" + new Date() + "\",");
            pw.println("    \"totalEmployees\": " + employees.size() + ",");
            pw.println("    \"employees\": [");
            
            for (int i = 0; i < employees.size(); i++) {
                pw.print(employees.get(i).toJSON());
                if (i < employees.size() - 1) {
                    pw.println(",");
                } else {
                    pw.println();
                }
            }
            
            pw.println("    ]");
            pw.println("  }");
            pw.println("}");
            
            System.out.println("JSON report generated: " + filename);
            System.out.println("Total employees: " + employees.size());
            
        } catch (IOException e) {
            System.out.println("Error generating JSON report: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        generateJSONReport("employee_report.json");
        
        // Display part of the generated report
        try (BufferedReader br = new BufferedReader(new FileReader("employee_report.json"))) {
            System.out.println("\n=== Generated JSON Report (first 10 lines) ===");
            String line;
            int lineCount = 0;
            while ((line = br.readLine()) != null && lineCount < 10) {
                System.out.println(line);
                lineCount++;
            }
            if (lineCount == 10) {
                System.out.println("... (truncated)");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}