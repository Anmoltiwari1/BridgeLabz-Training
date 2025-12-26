package Ecapsulation_Plymorphism;
abstract class Employee{
	private int id;
	private String name;
	private int baseS;
	
	Employee(int id, String name, int baseS){
		this.id = id;
		this.name = name;
		this.baseS = baseS;
	}
	
	public abstract int calculateSalary();
	
	void displayDetails() {
		System.out.println("Employee ID: " + id + " Name: " + name + " Base Salary: " + baseS + " Final Salary: " + calculateSalary());
	}
	
	void SetID(int id) {
		this.id = id;
	}
	
	int GetID() {
		return id;
	}
	
	void SetN(String name) {
		this.name = name;
	}
	
	String GetN() {
		return name;
	}
	
	void SetS(int baseS) {
		this.baseS = baseS;
	}
	
	int GetS() {
		return baseS;
	}
}

interface Department{
	void assignDepartment(String dep);
	String getDepartment();
}

class FullTimeEmployee extends Employee implements Department{
	private String department;
	
	FullTimeEmployee(int id, String name, int baseS){
		super(id, name, baseS);
	}
	
	public int calculateSalary(){
		return GetS();
	}
	
	public void assignDepartment(String dep) {
		this.department = dep;
	}
	
	public String getDepartment(){
		return department;
	}
}

class PartTimeEmployee extends Employee implements Department{
	private int hours;
	private int rate;
	private String department;
	
	PartTimeEmployee(int id, String name, int baseS, int hours, int rate, String department){
		super(id, name, baseS);
		this.hours = hours;
		this.rate = rate;
		this.department = department;
	}
	
	public int calculateSalary() {
		int a = GetS() + (hours * rate);
		return a;
		
	}
	
	public void assignDepartment(String dep) {
		this.department = dep;
	}
	
	public String getDepartment() {
		return department;
	}
}

public class EmployeeManagementSystem {
	public static void main(String[] args) {
		FullTimeEmployee fte = new FullTimeEmployee(101, "Alice", 50000);
		fte.assignDepartment("Engineering");
		fte.displayDetails();
		System.out.println("Department: " + fte.getDepartment());
		
		PartTimeEmployee pte = new PartTimeEmployee(102, "Bob", 10000, 20, 300, "Support");
		pte.assignDepartment("Customer Service");
		pte.displayDetails();
		System.out.println("Department: " + pte.getDepartment());
	}
}
