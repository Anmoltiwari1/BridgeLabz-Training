import java.util.*;
import java.time.*;

class Policy implements Comparable<Policy> {
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
    
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }
    
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
    
    public String toString() {
        return policyNumber + " (" + holderName + ", " + coverageType + ", $" + premium + ")";
    }
}

public class InsurancePolicyManagement {
    HashSet<Policy> hashSet = new HashSet<>();
    LinkedHashSet<Policy> linkedHashSet = new LinkedHashSet<>();
    TreeSet<Policy> treeSet = new TreeSet<>();
    
    void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }
    
    void displayAllPolicies() {
        System.out.println("\n=== All Unique Policies ===");
        for (Policy policy : hashSet) {
            System.out.println(policy);
        }
    }
    
    void displayPoliciesInOrder() {
        System.out.println("\n=== Policies in Insertion Order ===");
        for (Policy policy : linkedHashSet) {
            System.out.println(policy);
        }
    }
    
    void displayPoliciesByExpiry() {
        System.out.println("\n=== Policies Sorted by Expiry Date ===");
        for (Policy policy : treeSet) {
            System.out.println(policy + " - Expires: " + policy.expiryDate);
        }
    }
    
    void findExpiringSoon() {
        System.out.println("\n=== Policies Expiring in 30 Days ===");
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        
        for (Policy policy : treeSet) {
            if (policy.expiryDate.isBefore(thirtyDaysFromNow) || policy.expiryDate.isEqual(thirtyDaysFromNow)) {
                System.out.println(policy + " - Expires: " + policy.expiryDate);
            }
        }
    }
    
    void findByCoverageType(String coverageType) {
        System.out.println("\n=== " + coverageType + " Policies ===");
        for (Policy policy : hashSet) {
            if (policy.coverageType.equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }
    
    void performanceTest() {
        System.out.println("\n=== Performance Test ===");
        Policy testPolicy = new Policy("TEST001", "Test User", LocalDate.now().plusYears(1), "Test", 1000);
        
        // Add performance
        long start = System.nanoTime();
        hashSet.add(testPolicy);
        long hashAddTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        linkedHashSet.add(testPolicy);
        long linkedAddTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        treeSet.add(testPolicy);
        long treeAddTime = System.nanoTime() - start;
        
        // Search performance
        start = System.nanoTime();
        hashSet.contains(testPolicy);
        long hashSearchTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        linkedHashSet.contains(testPolicy);
        long linkedSearchTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        treeSet.contains(testPolicy);
        long treeSearchTime = System.nanoTime() - start;
        
        System.out.println("Add Time - HashSet: " + hashAddTime + "ns, LinkedHashSet: " + linkedAddTime + "ns, TreeSet: " + treeAddTime + "ns");
        System.out.println("Search Time - HashSet: " + hashSearchTime + "ns, LinkedHashSet: " + linkedSearchTime + "ns, TreeSet: " + treeSearchTime + "ns");
    }
    
    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        
        // Add sample policies
        system.addPolicy(new Policy("POL001", "John Doe", LocalDate.now().plusDays(15), "Health", 1200));
        system.addPolicy(new Policy("POL002", "Jane Smith", LocalDate.now().plusDays(45), "Auto", 800));
        system.addPolicy(new Policy("POL003", "Bob Johnson", LocalDate.now().plusDays(10), "Home", 1500));
        system.addPolicy(new Policy("POL004", "Alice Brown", LocalDate.now().plusDays(60), "Health", 1100));
        
        system.displayAllPolicies();
        system.displayPoliciesInOrder();
        system.displayPoliciesByExpiry();
        system.findExpiringSoon();
        system.findByCoverageType("Health");
        system.performanceTest();
    }
}