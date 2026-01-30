package com.example.Collectors;

import java.util.*;
import java.util.stream.Collectors;

class Student{
	private String name;
	private String grade;
	
	public Student(String name,String grade) {
		this.name=name;
		this.grade=grade;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGrade() {
		return grade;
	}
}

public class StudentGrouping{
	public static void main(String[] args) {
		List<Student> students=List.of(
				new Student("Anmol", "A"),
				new Student("Ravi","B"),
				new Student("Neha", "A"),
			    new Student("Karan", "C")
			    );
		
		Map<String, List<String>> result =
			    students.stream()
			            .collect(Collectors.groupingBy(
			                Student::getGrade,
			                Collectors.mapping(
			                    Student::getName,
			                    Collectors.toList()
			                )
			            ));

		System.out.println(result);

	}
}
