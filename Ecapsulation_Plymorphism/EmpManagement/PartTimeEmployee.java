package Ecapsulation_Plymorphism.EmpManagement;

public class PartTimeEmployee extends Employee implements Department{
    
    private String departement;
    private int hoursWorked;

    PartTimeEmployee(int id,String name,double hourlyRate,int hoursWorked){
        super(id, name, hourlyRate);
        this.hoursWorked=hoursWorked;
    }

    @Override
    public double calculateSalary(){
        return getSalary()*hoursWorked;
    }

    @Override
    public void assignDepartement(String DepartmentName){
        this.departement=DepartmentName;
    }


     @Override
    public String getDepartementDetails(){
        return departement;
    }
}
