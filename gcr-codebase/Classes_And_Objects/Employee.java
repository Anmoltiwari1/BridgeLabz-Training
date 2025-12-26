package Classes_And_Objects;
public class Employee{
    
    String name;
    int id;
    double salary;

    Employee(String name,int id,double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }

    public void displayEmployee(){
        System.out.println("Employee Name: "+name);
		System.out.println("Employee id: "+id);
		System.out.println("Employee Salary: "+salary);
    }

    public static void main(String[] args) {
        Employee emp=new Employee("Roham", 1, 1500000);
        emp.displayEmployee();
    }
}