public class EmployeeBonusCalculator {
    public static double[][] generateEmployeeData() {
        double[][] employeeData = new double[10][2];
        
        for (int i = 0; i < 10; i++) {
            employeeData[i][0] = (int) (Math.random() * 90000) + 10000;
            employeeData[i][1] = (int) (Math.random() * 10) + 1;
        }
        
        return employeeData;
    }
    
    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        double[][] bonusData = new double[10][2];
        
        for (int i = 0; i < 10; i++) {
            double salary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonusPercentage;
            
            if (yearsOfService > 5) {
                bonusPercentage = 0.05;
            } else {
                bonusPercentage = 0.02;
            }
            
            double bonusAmount = salary * bonusPercentage;
            double newSalary = salary + bonusAmount;
            
            bonusData[i][0] = newSalary;
            bonusData[i][1] = bonusAmount;
        }
        
        return bonusData;
    }
    
    public static double[] calculateTotals(double[][] employeeData, double[][] bonusData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonusAmount = 0;
        
        for (int i = 0; i < 10; i++) {
            totalOldSalary += employeeData[i][0];
            totalNewSalary += bonusData[i][0];
            totalBonusAmount += bonusData[i][1];
        }
        
        return new double[]{totalOldSalary, totalNewSalary, totalBonusAmount};
    }
    
    public static void displayResults(double[][] employeeData, double[][] bonusData) {
        System.out.println("ZARA COMPANY - EMPLOYEE BONUS CALCULATION");
        System.out.println("==========================================");
        System.out.println();
        
        System.out.printf("%-8s %-12s %-8s %-8s %-12s %-12s%n", 
                         "Employee", "Old Salary", "Years", "Bonus%", "Bonus Amt", "New Salary");
        System.out.println("------------------------------------------------------------------------");
        
        for (int i = 0; i < 10; i++) {
            double oldSalary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonusAmount = bonusData[i][1];
            double newSalary = bonusData[i][0];
            String bonusPercentage = (yearsOfService > 5) ? "5%" : "2%";
            
            System.out.printf("%-8d $%-11.0f %-8.0f %-8s $%-11.0f $%-11.0f%n", 
                             (i + 1), oldSalary, yearsOfService, bonusPercentage, 
                             bonusAmount, newSalary);
        }
        
        System.out.println("------------------------------------------------------------------------");
        
        double[] totals = calculateTotals(employeeData, bonusData);
        
        System.out.printf("%-8s $%-11.0f %-8s %-8s $%-11.0f $%-11.0f%n", 
                         "TOTAL", totals[0], "", "", totals[2], totals[1]);
        
        System.out.println();
        System.out.println("SUMMARY:");
        System.out.println("--------");
        System.out.printf("Total Old Salary Amount: $%.0f%n", totals[0]);
        System.out.printf("Total New Salary Amount: $%.0f%n", totals[1]);
        System.out.printf("Total Bonus Amount: $%.0f%n", totals[2]);
        System.out.printf("Company's Additional Expense: $%.0f%n", totals[2]);
        
        System.out.println();
        System.out.println("BONUS POLICY:");
        System.out.println("- Employees with > 5 years service: 5% bonus");
        System.out.println("- Employees with ≤ 5 years service: 2% bonus");
    }
    
    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData();
        double[][] bonusData = calculateBonusAndNewSalary(employeeData);
        
        displayResults(employeeData, bonusData);
    }
}
