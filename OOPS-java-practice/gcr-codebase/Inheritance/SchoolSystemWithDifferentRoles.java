class Person{
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	void Display() {
		System.out.print("Name: " + name + " Age: " + age);
	}
}

class Teacher extends Person{
	String subject;
	
	Teacher(String name, int age, String subject){
		super(name, age);
		this.subject = subject;
	}
	
	void displayRole() {
		System.out.println("Role: Teacher");
	}
	
	void Display() {
		super.Display();
		System.out.print(" Subject: " + subject);
	}
}

class Student extends Person{
	String grade;
	
	Student(String name, int age, String grade){
		super(name, age);
		this.grade = grade;
	}
	
	void displayRole() {
		System.out.println("Role: Student");
	}
	
	void Display() {
		super.Display();
		System.out.print(" Grade: " + grade);
	}
}

class Staff extends Person{
	
	Staff(String name, int age){
		super(name, age);
	}
	
	void displayRole() {
		System.out.println("Role: Staff");
	}
	
	void Display() {
		super.Display();
	}
	
}

public class SchoolSystemWithDifferentRoles {
	public static void main(String[] args) {
		Teacher t1 = new Teacher("Alice", 25, "Maths");
		Student s1 = new Student("Bob", 15, "A");
		Staff st1 = new Staff("John", 30);
		t1.displayRole();
		t1.Display();
		System.out.println();
		s1.displayRole();
		s1.Display();
		System.out.println();
		st1.displayRole();
		st1.Display();
	}
}
