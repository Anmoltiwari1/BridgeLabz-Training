import java.util.*;
import java.util.stream.Collectors;

class InsuranceClaim {
    private String claimId;
    private String claimType;
    private double amount;
    
    public InsuranceClaim(String claimId, String claimType, double amount) {
        this.claimId = claimId;
        this.claimType = claimType;
        this.amount = amount;
    }
    
    public String getClaimId() { return claimId; }
    public String getClaimType() { return claimType; }
    public double getAmount() { return amount; }
    
    @Override
    public String toString() {
        return claimId + " (" + claimType + "): $" + amount;
    }
}

public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        List<InsuranceClaim> claims = Arrays.asList(
            new InsuranceClaim("C001", "Auto", 2500.00),
            new InsuranceClaim("C002", "Health", 1200.00),
            new InsuranceClaim("C003", "Auto", 3200.00),
            new InsuranceClaim("C004", "Home", 5500.00),
            new InsuranceClaim("C005", "Health", 800.00),
            new InsuranceClaim("C006", "Auto", 1800.00),
            new InsuranceClaim("C007", "Health", 2200.00),
            new InsuranceClaim("C008", "Home", 4200.00),
            new InsuranceClaim("C009", "Auto", 2800.00),
            new InsuranceClaim("C010", "Health", 1500.00)
        );
        
        Map<String, Double> avgClaimByType = claims.stream()
            .collect(Collectors.groupingBy(
                InsuranceClaim::getClaimType,
                Collectors.averagingDouble(InsuranceClaim::getAmount)
            ));
        
        System.out.println("Average claim amount by type:");
        avgClaimByType.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry -> 
                System.out.printf("%s: $%.2f%n", entry.getKey(), entry.getValue()));
        
        Map<String, Long> claimCountByType = claims.stream()
            .collect(Collectors.groupingBy(
                InsuranceClaim::getClaimType,
                Collectors.counting()
            ));
        
        System.out.println("\nClaim count by type:");
        claimCountByType.forEach((type, count) -> 
            System.out.println(type + ": " + count + " claims"));
        
        double totalClaimAmount = claims.stream()
            .mapToDouble(InsuranceClaim::getAmount)
            .sum();
        
        System.out.printf("\nTotal claim amount: $%.2f%n", totalClaimAmount);
    }
}