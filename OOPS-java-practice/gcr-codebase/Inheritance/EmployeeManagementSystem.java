class Employee{
	String name;
	int id;
	int salary;
	
	Employee(String name, int id, int salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	void Display() {
		System.out.println("Employee ID: " + id + " Name: " + name + " Salary: " + salary);
	}
}

class Manager extends Employee{
	int size = 15;
	
	Manager(String name, int id, int salary){
		super(name, id, salary);
	}
	
	void Size() {
		System.out.println("Team Size: " + size);
	}
}

class Developer extends Employee{
	String lan = "Java";
	
	Developer(String name, int id, int salary){
		super(name, id, salary);
	}
	
	void Lang() {
		System.out.println("The Programming Language is: " + lan);
	}
}

class Intern extends Employee{
	
	Intern(String name, int id, int salary){
		super(name, id, salary);
	}
}

public class EmployeeManagementSystem {
	public static void main(String[] args) {
		Manager m = new Manager("Bob", 106, 65000);
		Developer d = new Developer("John", 102, 50000);
		Intern i = new Intern("Alice", 103, 25000);
		m.Display();
		m.Size();
		d.Display();
		d.Lang();
		i.Display();
	}
}
