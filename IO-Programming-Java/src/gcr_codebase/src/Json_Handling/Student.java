package Json_Handling;

import java.util.*;

public class Student {
	private String name;
	private int age;
	private List<String> subjects;
	
	public Student() {
		
	}
	
	public Student(String name, int age, List<String> subjects) {
		super();
		this.name = name;
		this.age = age;
		this.subjects = subjects;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	
	
	
	
}
