import java.util.*;
import java.util.stream.*;
import java.util.function.*;

@FunctionalInterface
interface WageCalculator {
    int calculate(int hours, int wagePerHour);
}

// UC12: Interface approach
interface IEmpWageBuilder {
    void addCompany(String company, int wagePerHour, int workingDays, int maxHours);
    void computeWages();
    int getTotalWage(String company);
    Map<String, Integer> getAllWages();
}

// UC10: CompanyEmpWage class
class CompanyEmpWage {
    String company;
    int wagePerHour; // UC2: Wage per hour
    int workingDays; // UC5: Working days per month
    int maxHours; // UC6: Max hours condition
    int totalWage; // UC9: Save total wage
    List<Integer> dailyWages; // UC13: Store daily wages
    
    CompanyEmpWage(String company, int wagePerHour, int workingDays, int maxHours) {
        this.company = company;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.maxHours = maxHours;
        this.dailyWages = new ArrayList<>();
    }
    
    public String getCompany() { return company; }
    public int getTotalWage() { return totalWage; }
    public List<Integer> getDailyWages() { return dailyWages; }
}

// UC11: EmpWageBuilder with ArrayList
class EmpWageBuilder implements IEmpWageBuilder {
    static final int FULL_DAY_HOURS = 8; // UC2: Full day hours
    static final int PART_TIME_HOURS = 4; // UC3: Part time hours
    static final int IS_ABSENT = 0; // UC1: Absent
    static final int IS_FULL_TIME = 1; // UC1: Full time
    static final int IS_PART_TIME = 2; // UC1: Part time
    
    List<CompanyEmpWage> companies; // UC11: ArrayList for multiple companies
    WageCalculator wageCalculator;
    
    EmpWageBuilder() {
        companies = new ArrayList<>();
        wageCalculator = (hours, wagePerHour) -> hours * wagePerHour; // UC7: Lambda for wage calculation
    }
    
    // UC8: Add company with parameters
    public void addCompany(String company, int wagePerHour, int workingDays, int maxHours) {
        companies.add(new CompanyEmpWage(company, wagePerHour, workingDays, maxHours));
    }
    
    // UC8: Compute wages for all companies
    public void computeWages() {
        companies.forEach(company -> {
            company.totalWage = computeCompanyWage(company);
            System.out.println("Total wage for " + company.company + ": Rs." + company.totalWage);
        });
    }
    
    // UC7: Class method to compute wage
    int computeCompanyWage(CompanyEmpWage company) {
        Supplier<Integer> randomEmpType = () -> (int)(Math.random() * 3); // UC1: Random attendance
        Function<Integer, Integer> getHours = empType -> {
            switch (empType) { // UC4: Switch case
                case IS_FULL_TIME: return FULL_DAY_HOURS; // UC2: Full time
                case IS_PART_TIME: return PART_TIME_HOURS; // UC3: Part time
                default: return 0; // UC1: Absent
            }
        };
        
        int totalHours = 0, totalDays = 0;
        
        // UC6: Calculate till max hours or days
        while (totalHours < company.maxHours && totalDays < company.workingDays) {
            int dailyHours = getHours.apply(randomEmpType.get());
            
            if (totalHours + dailyHours > company.maxHours) {
                dailyHours = company.maxHours - totalHours;
            }
            
            totalHours += dailyHours;
            int dailyWage = wageCalculator.calculate(dailyHours, company.wagePerHour); // UC2: Calculate daily wage
            company.dailyWages.add(dailyWage); // UC13: Store daily wage
            totalDays++;
        }
        
        return company.dailyWages.stream().mapToInt(Integer::intValue).sum(); // UC13: Sum using streams
    }
    
    // UC14: Get total wage by company
    public int getTotalWage(String company) {
        return companies.stream()
                .filter(c -> c.company.equals(company))
                .findFirst()
                .map(c -> c.totalWage)
                .orElse(-1);
    }
    
    // UC13: Get all wages as map
    public Map<String, Integer> getAllWages() {
        return companies.stream()
                .collect(Collectors.toMap(
                    CompanyEmpWage::getCompany,
                    CompanyEmpWage::getTotalWage
                ));
    }
    
    public void printWageSummary() {
        System.out.println("\n=== Wage Summary ===");
        DoubleSummaryStatistics stats = companies.stream()
                .mapToDouble(CompanyEmpWage::getTotalWage)
                .summaryStatistics();
        
        System.out.println("Total Companies: " + stats.getCount());
        System.out.println("Total Wages Paid: Rs." + stats.getSum());
        System.out.println("Average Wage: Rs." + String.format("%.2f", stats.getAverage()));
        System.out.println("Max Wage: Rs." + stats.getMax());
        System.out.println("Min Wage: Rs." + stats.getMin());
    }
    
    public void printCompaniesAboveThreshold(int threshold) {
        System.out.println("\nCompanies with wage above Rs." + threshold + ":");
        companies.stream()
                .filter(c -> c.totalWage > threshold)
                .forEach(c -> System.out.println(c.company + ": Rs." + c.totalWage));
    }
}

public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        
        EmpWageBuilder builder = new EmpWageBuilder();
        
        // UC8: Multiple companies with different parameters
        builder.addCompany("TCS", 20, 20, 100);
        builder.addCompany("Infosys", 25, 22, 120);
        builder.addCompany("Wipro", 18, 20, 100);
        builder.addCompany("Amazon", 30, 20, 100);
        
        builder.computeWages();
        
        // UC14: Query wages by company
        System.out.println("\n=== Querying Wages ===");
        builder.getAllWages().forEach((company, wage) -> 
            System.out.println(company + " Total Wage: Rs." + wage)
        );
        
        builder.printWageSummary();
        builder.printCompaniesAboveThreshold(2000);
    }
}