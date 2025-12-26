package Ecapsulation_Plymorphism.Employee_Management_System.Employee_Managment_System;

public abstract class Employee {
    
    private int employeeId;
    private String name;
    private double baseSalary;
    
    Employee(int employeeId,String name,double baseSalary){
        this.employeeId=employeeId;
        this.name=name;
        this.baseSalary=baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDeatils(){
         System.out.println("ID      : " + employeeId);
        System.out.println("Name    : " + name);
        System.out.println("Salary  : " + calculateSalary());
    }

    public int getEmployeeId(){
        return employeeId;
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary){
        this.baseSalary=baseSalary;
    }
}
