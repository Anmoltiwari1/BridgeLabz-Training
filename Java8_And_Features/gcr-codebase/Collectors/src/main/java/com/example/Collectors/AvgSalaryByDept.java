package com.example.Collectors;

import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class AvgSalaryByDept {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Anmol", "IT", 60000),
            new Employee("Ravi", "HR", 40000),
            new Employee("Neha", "IT", 80000),
            new Employee("Priya", "HR", 50000)
        );

        Map<String, Double> avgSalaryByDept =
            employees.stream()
                     .collect(Collectors.groupingBy(
                         Employee::getDepartment,
                         Collectors.averagingDouble(Employee::getSalary)
                     ));

        System.out.println(avgSalaryByDept);
    }
}
