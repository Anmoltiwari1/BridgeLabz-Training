import java.util.*;

// UC12: Interface approach
interface IEmpWageBuilder {
    void addCompany(String company, int wagePerHour, int workingDays, int maxHours);
    void computeWages();
    int getTotalWage(String company);
}

// UC10: CompanyEmpWage class
class CompanyEmpWage {
    String company;
    int wagePerHour;
    int workingDays;
    int maxHours;
    int totalWage;
    List<Integer> dailyWages;
    
    CompanyEmpWage(String company, int wagePerHour, int workingDays, int maxHours) {
        this.company = company;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.maxHours = maxHours;
        this.dailyWages = new ArrayList<>();
    }
}

// UC11: EmpWageBuilder to manage multiple companies
class EmpWageBuilder implements IEmpWageBuilder {
    // UC2: Constants
    static final int FULL_DAY_HOURS = 8;
    static final int PART_TIME_HOURS = 4;
    static final int IS_ABSENT = 0;
    static final int IS_FULL_TIME = 1;
    static final int IS_PART_TIME = 2;
    
    List<CompanyEmpWage> companies; // UC11: ArrayList for multiple companies
    
    EmpWageBuilder() {
        companies = new ArrayList<>();
    }
    
    // UC8: Add company with parameters
    public void addCompany(String company, int wagePerHour, int workingDays, int maxHours) {
        companies.add(new CompanyEmpWage(company, wagePerHour, workingDays, maxHours));
    }
    
    // UC8: Compute wages for all companies
    public void computeWages() {
        for (CompanyEmpWage company : companies) {
            company.totalWage = computeCompanyWage(company);
            System.out.println("Total wage for " + company.company + ": Rs." + company.totalWage);
        }
    }
    
    // UC7: Class method to compute wage
    int computeCompanyWage(CompanyEmpWage company) {
        int totalHours = 0, totalDays = 0, totalWage = 0;
        
        // UC6: Calculate till max hours or days
        while (totalHours < company.maxHours && totalDays < company.workingDays) {
            int empType = (int)(Math.random() * 3); // UC1: Random attendance
            int dailyHours = 0;
            
            // UC4: Switch case
            switch (empType) {
                case IS_FULL_TIME:
                    dailyHours = FULL_DAY_HOURS; // UC2: Full time
                    break;
                case IS_PART_TIME:
                    dailyHours = PART_TIME_HOURS; // UC3: Part time
                    break;
                case IS_ABSENT:
                    dailyHours = 0; // UC1: Absent
                    break;
            }
            
            if (totalHours + dailyHours > company.maxHours) {
                dailyHours = company.maxHours - totalHours;
            }
            
            totalHours += dailyHours;
            int dailyWage = dailyHours * company.wagePerHour; // UC2: Calculate daily wage
            company.dailyWages.add(dailyWage); // UC13: Store daily wage
            totalWage += dailyWage;
            totalDays++;
        }
        
        return totalWage; // UC9: Save total wage
    }
    
    // UC14: Get total wage by company
    public int getTotalWage(String company) {
        for (CompanyEmpWage c : companies) {
            if (c.company.equals(company)) {
                return c.totalWage;
            }
        }
        return -1;
    }
}

public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");
        
        EmpWageBuilder builder = new EmpWageBuilder();
        
        // UC8: Multiple companies with different parameters
        builder.addCompany("TCS", 20, 20, 100);
        builder.addCompany("Infosys", 25, 22, 120);
        builder.addCompany("Wipro", 18, 20, 100);
        
        // UC8: Compute wages
        builder.computeWages();
        
        // UC14: Query wages by company
        System.out.println("\nQuerying wages:");
        System.out.println("TCS Total Wage: Rs." + builder.getTotalWage("TCS"));
        System.out.println("Infosys Total Wage: Rs." + builder.getTotalWage("Infosys"));
    }
}