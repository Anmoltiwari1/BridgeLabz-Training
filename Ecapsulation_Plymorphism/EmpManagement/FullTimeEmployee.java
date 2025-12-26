package Ecapsulation_Plymorphism.EmpManagement;

public class FullTimeEmployee extends Employee implements Department{
    
    private double bonus;
    private String departement;

    public FullTimeEmployee(int id,String name,double baseSalary,double bonus){
        super(id, name, baseSalary);
        this.bonus=bonus;
    }

    @Override
    public double calculateSalary(){
        return getSalary()+bonus;
    }

    @Override
    public void assignDepartement(String departmentName){
        this.departement=departmentName;
    }

    @Override
    public String getDepartementDetails(){
        return departement;
    }
}
