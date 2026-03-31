package EmplyeeRecords;
public class Employee {

    public int employeeID;       // accessible anywhere
    protected String department; // accessible in subclass & same package
    private double salary;       // accessible only inside Employee

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {
        if(salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative.");
        }
    }

    // Optional: method to view salary
    public double getSalary() {
        return salary;
    }
}
