import java.util.*;
import java.time.*;

class Policy {
    String policyNumber, holderName, coverageType;
    LocalDate expiryDate;
    double premium;
    
    Policy(String policyNumber, String holderName, LocalDate expiryDate, String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }
    
    public String toString() {
        return policyNumber + " - " + holderName + " (" + coverageType + ", $" + premium + ", Expires: " + expiryDate + ")";
    }
}

public class InsurancePolicySystem {
    HashMap<String, Policy> hashMap = new HashMap<>();
    LinkedHashMap<String, Policy> linkedHashMap = new LinkedHashMap<>();
    TreeMap<LocalDate, Policy> treeMap = new TreeMap<>();
    
    void addPolicy(Policy policy) {
        hashMap.put(policy.policyNumber, policy);
        linkedHashMap.put(policy.policyNumber, policy);
        treeMap.put(policy.expiryDate, policy);
    }
    
    Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }
    
    List<Policy> getPoliciesExpiringSoon() {
        List<Policy> expiring = new ArrayList<>();
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        
        for (Policy policy : hashMap.values()) {
            if (policy.expiryDate.isBefore(thirtyDaysFromNow) || policy.expiryDate.isEqual(thirtyDaysFromNow)) {
                expiring.add(policy);
            }
        }
        return expiring;
    }
    
    List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : hashMap.values()) {
            if (policy.holderName.equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }
    
    void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        hashMap.entrySet().removeIf(entry -> entry.getValue().expiryDate.isBefore(today));
        linkedHashMap.entrySet().removeIf(entry -> entry.getValue().expiryDate.isBefore(today));
        treeMap.entrySet().removeIf(entry -> entry.getKey().isBefore(today));
    }
    
    void displayPoliciesInOrder() {
        System.out.println("\n=== Policies in Insertion Order ===");
        for (Policy policy : linkedHashMap.values()) {
            System.out.println(policy);
        }
    }
    
    void displayPoliciesByExpiry() {
        System.out.println("\n=== Policies Sorted by Expiry Date ===");
        for (Policy policy : treeMap.values()) {
            System.out.println(policy);
        }
    }
    
    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();
        
        // Add policies
        system.addPolicy(new Policy("POL001", "John Doe", LocalDate.now().plusDays(15), "Health", 1200));
        system.addPolicy(new Policy("POL002", "Jane Smith", LocalDate.now().plusDays(45), "Auto", 800));
        system.addPolicy(new Policy("POL003", "John Doe", LocalDate.now().plusDays(10), "Home", 1500));
        system.addPolicy(new Policy("POL004", "Bob Johnson", LocalDate.now().minusDays(5), "Health", 1100));
        
        // Retrieve policy by number
        System.out.println("Policy POL001: " + system.getPolicyByNumber("POL001"));
        
        // Policies expiring soon
        System.out.println("\nPolicies expiring in 30 days:");
        for (Policy policy : system.getPoliciesExpiringSoon()) {
            System.out.println(policy);
        }
        
        // Policies by holder
        System.out.println("\nJohn Doe's policies:");
        for (Policy policy : system.getPoliciesByHolder("John Doe")) {
            System.out.println(policy);
        }
        
        system.displayPoliciesInOrder();
        system.displayPoliciesByExpiry();
        
        // Remove expired policies
        system.removeExpiredPolicies();
        System.out.println("\nAfter removing expired policies:");
        system.displayPoliciesInOrder();
    }
}