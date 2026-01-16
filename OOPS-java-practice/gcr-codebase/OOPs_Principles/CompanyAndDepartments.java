import java.util.*;
class Company{
	String name;
	ArrayList <Department> dep = new ArrayList<>();
	
	Company(String name){
		this.name = name;
	}
	
	void Add(String n) {
		dep.add(new Department(n));
	}
	
	void DiplayC(){
		System.out.println("Company: " + name);
		for(int i = 0; i < dep.size(); i++) {
			Department d = dep.get(i);
			System.out.println("Department: " + d.name);
		}
	}
}

class Department{
	String name;
	ArrayList<Employee> em = new ArrayList<>();
	
	Department(String name){
		this.name = name;
	}
	
	void Add(String n, int i) {
		em.add(new Employee(n, i));
	}
	
	void Display() {
		System.out.println("Department: " + name);
		for(int i = 0; i < em.size(); i++) {
			Employee e = em.get(i);
			System.out.println("Employee Name: " + e.name + " ID: " + e.ID);
		}
	}
}

class Employee{
	String name;
	int ID;
	
	Employee(String name, int ID){
		this.name = name;
		this.ID = ID;
	}
}

public class CompanyAndDepartments {
	public static void main(String[] args) {
		Company c1 = new Company("Google");
		c1.Add("IT");
		c1.Add("Accounts");
		c1.dep.get(0).Add("Alice", 101);
		c1.dep.get(0).Add("Bob", 102);
		c1.dep.get(1).Add("Charles", 202);
		c1.DiplayC();
		c1.dep.get(0).Display();
		c1.dep.get(1).Display();
	}
}
