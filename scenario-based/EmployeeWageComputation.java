import java.util.*;

// Employee Wage Computation Program
// Demonstrates Java programming constructs, classes, objects, and collections
public class EmployeeWageComputation {
    // Class variables (constants)
    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;
    private static final int WORKING_DAYS_PER_MONTH = 20;
    private static final int MAX_WORKING_HOURS = 100;
    private static final int MAX_WORKING_DAYS = 20;
    
    // Instance variables
    private String employeeName;
    private List<Integer> dailyWages;
    private int totalWorkingDays;
    private int totalWorkingHours;
    
    // Constructor
    public EmployeeWageComputation(String name) {
        this.employeeName = name;
        this.dailyWages = new ArrayList<>();
        this.totalWorkingDays = 0;
        this.totalWorkingHours = 0;
    }
    
    public static void main(String[] args) {
        // Display welcome message
        System.out.println("=== Welcome to Employee Wage Computation Program ===");
        System.out.println("Running on Master Branch");
        System.out.println();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        
        // Create employee object
        EmployeeWageComputation employee = new EmployeeWageComputation(name);
        
        System.out.println("\nWelcome " + name + "!");
        System.out.println("Your wage computation is as follows:\n");
        
        // UC1: Check attendance and calculate daily wage
        employee.checkAttendanceAndCalculateWage();
        
        // UC5: Calculate wages for a month
        employee.calculateMonthlyWages();
        
        // UC6: Calculate wages till condition is reached
        employee.calculateWagesTillCondition();
        
        System.out.println("\nThank You for using Employee Wage Computation Program!");
        sc.close();
    }
    
    // UC1: Check Employee Attendance using Random
    public boolean checkAttendance() {
        int attendance = (int)(Math.random() * 2); // 0 or 1
        return attendance == 1;
    }
    
    // UC2 & UC3: Calculate Daily Wage with Part-time support using Switch Case
    public int calculateDailyWage() {
        if (!checkAttendance()) {
            System.out.println("Employee is Absent - No wage for today");
            return 0;
        }
        
        System.out.println("Employee is Present");
        
        // Random work type: 1=Full-time, 2=Part-time
        int workType = (int)(Math.random() * 2) + 1;
        int dailyWage = 0;
        int hoursWorked = 0;
        
        // UC4: Using Switch Case Statement
        switch(workType) {
            case 1: // Full-time
                hoursWorked = FULL_DAY_HOURS;
                dailyWage = FULL_DAY_HOURS * WAGE_PER_HOUR;
                System.out.println("Work Type: Full-time (" + FULL_DAY_HOURS + " hours)");
                break;
            case 2: // Part-time
                hoursWorked = PART_TIME_HOURS;
                dailyWage = PART_TIME_HOURS * WAGE_PER_HOUR;
                System.out.println("Work Type: Part-time (" + PART_TIME_HOURS + " hours)");
                break;
            default:
                System.out.println("Invalid work type");
        }
        
        totalWorkingHours += hoursWorked;
        System.out.println("Daily Wage: Rs. " + dailyWage);
        return dailyWage;
    }
    
    // Method to check attendance and calculate single day wage
    public void checkAttendanceAndCalculateWage() {
        System.out.println("=== UC1 & UC2: Daily Wage Calculation ===");
        int wage = calculateDailyWage();
        System.out.println("Today's wage: Rs. " + wage);
        System.out.println();
    }
    
    // UC5: Calculate Wages for a Month (20 working days)
    public void calculateMonthlyWages() {
        System.out.println("=== UC5: Monthly Wage Calculation ===");
        dailyWages.clear();
        totalWorkingDays = 0;
        totalWorkingHours = 0;
        int totalMonthlyWage = 0;
        
        for(int day = 1; day <= WORKING_DAYS_PER_MONTH; day++) {
            System.out.println("\nDay " + day + ":");
            int dailyWage = calculateDailyWage();
            
            if(dailyWage > 0) {
                totalWorkingDays++;
                dailyWages.add(dailyWage);
            }
            totalMonthlyWage += dailyWage;
        }
        
        System.out.println("\n--- Monthly Summary ---");
        System.out.println("Total Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Monthly Wage: Rs. " + totalMonthlyWage);
        System.out.println();
    }
    
    // UC6: Calculate wages till condition is reached (100 hours or 20 days)
    public void calculateWagesTillCondition() {
        System.out.println("=== UC6: Wage Calculation Till Condition ===");
        System.out.println("Condition: Maximum 100 hours OR 20 working days");
        
        dailyWages.clear();
        totalWorkingDays = 0;
        totalWorkingHours = 0;
        int totalWage = 0;
        int day = 1;
        
        // Continue until either condition is met
        while(totalWorkingHours < MAX_WORKING_HOURS && totalWorkingDays < MAX_WORKING_DAYS) {
            System.out.println("\nDay " + day + ":");
            
            if(!checkAttendance()) {
                System.out.println("Employee is Absent");
                day++;
                continue;
            }
            
            System.out.println("Employee is Present");
            
            // Random work type
            int workType = (int)(Math.random() * 2) + 1;
            int dailyWage = 0;
            int hoursWorked = 0;
            
            switch(workType) {
                case 1: // Full-time
                    hoursWorked = FULL_DAY_HOURS;
                    dailyWage = FULL_DAY_HOURS * WAGE_PER_HOUR;
                    System.out.println("Work Type: Full-time (" + FULL_DAY_HOURS + " hours)");
                    break;
                case 2: // Part-time
                    hoursWorked = PART_TIME_HOURS;
                    dailyWage = PART_TIME_HOURS * WAGE_PER_HOUR;
                    System.out.println("Work Type: Part-time (" + PART_TIME_HOURS + " hours)");
                    break;
            }
            
            // Check if adding these hours would exceed limit
            if(totalWorkingHours + hoursWorked > MAX_WORKING_HOURS) {
                int remainingHours = MAX_WORKING_HOURS - totalWorkingHours;
                dailyWage = remainingHours * WAGE_PER_HOUR;
                hoursWorked = remainingHours;
                System.out.println("Adjusted hours to meet limit: " + remainingHours + " hours");
            }
            
            totalWorkingHours += hoursWorked;
            totalWorkingDays++;
            totalWage += dailyWage;
            dailyWages.add(dailyWage);
            
            System.out.println("Daily Wage: Rs. " + dailyWage);
            System.out.println("Total Hours: " + totalWorkingHours + "/" + MAX_WORKING_HOURS);
            System.out.println("Total Days: " + totalWorkingDays + "/" + MAX_WORKING_DAYS);
            
            day++;
        }
        
        // Display final summary
        System.out.println("\n--- Final Summary ---");
        System.out.println("Employee: " + employeeName);
        System.out.println("Total Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Wage Earned: Rs. " + totalWage);
        
        // Display condition met
        if(totalWorkingHours >= MAX_WORKING_HOURS) {
            System.out.println("Condition Met: Maximum working hours (" + MAX_WORKING_HOURS + ") reached");
        }
        if(totalWorkingDays >= MAX_WORKING_DAYS) {
            System.out.println("Condition Met: Maximum working days (" + MAX_WORKING_DAYS + ") reached");
        }
        
        // Using Collection Library - Display daily wages
        System.out.println("\nDaily Wages History: " + dailyWages);
    }
    
    // Getter methods (demonstrating encapsulation)
    public String getEmployeeName() {
        return employeeName;
    }
    
    public List<Integer> getDailyWages() {
        return new ArrayList<>(dailyWages); // Return copy to maintain encapsulation
    }
    
    public int getTotalWorkingDays() {
        return totalWorkingDays;
    }
    
    public int getTotalWorkingHours() {
        return totalWorkingHours;
    }
}