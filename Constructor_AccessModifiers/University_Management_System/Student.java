package University_Management_System;
public class Student {
    
    public int rollNumber;
    protected String name;
    private double CGPA;

    Student(int rollNumber,String name,double CGPA){
        this.rollNumber=rollNumber;
        this.name=name;
        this.CGPA=CGPA;
    }

    public void setCGPA(double cgpa){
        this.CGPA=cgpa;
    }

    public double getCGPA(){
        return CGPA;
    }
}
