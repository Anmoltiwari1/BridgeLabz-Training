import java.util.*;

public class EmployeeWageComputation {
    // Class variables
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOURS = 8;
    static final int PART_TIME_HOURS = 4;
    static final int WORKING_DAYS = 20;
    static final int MAX_HOURS = 100;
    
    // Instance variables
    String name;
    List<Integer> dailyWages = new ArrayList<>();
    
    public EmployeeWageComputation(String name) {
        this.name = name;
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        EmployeeWageComputation emp = new EmployeeWageComputation(sc.nextLine());
        
        // UC1: Check attendance and calculate daily wage
        emp.calculateDailyWage();
        
        // UC5: Calculate monthly wages
        emp.calculateMonthlyWages();
        
        // UC6: Calculate wages till condition
        emp.calculateWagesTillCondition();
        
        sc.close();
    }
    
    // UC1: Random attendance check
    boolean isPresent() {
        return Math.random() < 0.5;
    }
    
    // UC2 & UC4: Calculate daily wage using switch case
    int getDailyWage() {
        if (!isPresent()) return 0;
        
        int empType = (int)(Math.random() * 2) + 1;
        switch(empType) {
            case 1: return FULL_DAY_HOURS * WAGE_PER_HOUR;  // UC2: Full time
            case 2: return PART_TIME_HOURS * WAGE_PER_HOUR; // UC3: Part time
            default: return 0;
        }
    }
    
    void calculateDailyWage() {
        int wage = getDailyWage();
        System.out.println("Daily Wage: Rs." + wage);
    }
    
    // UC5: Monthly wage calculation
    void calculateMonthlyWages() {
        int totalWage = 0;
        for(int day = 1; day <= WORKING_DAYS; day++) {
            int wage = getDailyWage();
            dailyWages.add(wage);
            totalWage += wage;
        }
        System.out.println("Monthly Wage: Rs." + totalWage);
    }
    
    // UC6: Calculate till condition (100 hours or 20 days)
    void calculateWagesTillCondition() {
        int totalHours = 0, workingDays = 0, totalWage = 0;
        
        while(totalHours < MAX_HOURS && workingDays < WORKING_DAYS) {
            if(isPresent()) {
                int hours = (Math.random() < 0.5) ? FULL_DAY_HOURS : PART_TIME_HOURS;
                if(totalHours + hours > MAX_HOURS) hours = MAX_HOURS - totalHours;
                
                totalHours += hours;
                workingDays++;
                totalWage += hours * WAGE_PER_HOUR;
            }
        }
        
        System.out.println("Total Hours: " + totalHours + ", Days: " + workingDays + ", Wage: Rs." + totalWage);
    }
}