package EmplyeeRecords;

// Manager.java
public class Manager extends Employee {

    // Constructor
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    // Method to display employeeID and department
    public void displayInfo() {
        System.out.println("Employee ID: " + employeeID); // public: accessible
        System.out.println("Department: " + department);  // protected: accessible
        // System.out.println("Salary: " + salary);      // ❌ private: NOT accessible
    }
}

