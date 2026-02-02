import java.time.LocalDate;
import java.util.*;

class GymMember {
    private String name;
    private LocalDate membershipExpiry;
    
    public GymMember(String name, LocalDate membershipExpiry) {
        this.name = name;
        this.membershipExpiry = membershipExpiry;
    }
    
    public String getName() { return name; }
    public LocalDate getMembershipExpiry() { return membershipExpiry; }
    
    @Override
    public String toString() {
        return name + " - Expires: " + membershipExpiry;
    }
}

public class FilteringExpiringMemberships {
    public static void main(String[] args) {
        List<GymMember> members = Arrays.asList(
            new GymMember("Alice", LocalDate.now().plusDays(15)),
            new GymMember("Bob", LocalDate.now().plusDays(45)),
            new GymMember("Charlie", LocalDate.now().plusDays(25)),
            new GymMember("Diana", LocalDate.now().plusDays(5)),
            new GymMember("Eve", LocalDate.now().plusDays(60)),
            new GymMember("Frank", LocalDate.now().plusDays(10)),
            new GymMember("Grace", LocalDate.now().plusDays(35)),
            new GymMember("Henry", LocalDate.now().plusDays(20))
        );
        
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        
        System.out.println("Members with expiring memberships (within 30 days):");
        
        members.stream()
            .filter(member -> member.getMembershipExpiry().isBefore(thirtyDaysFromNow) || 
                             member.getMembershipExpiry().isEqual(thirtyDaysFromNow))
            .sorted(Comparator.comparing(GymMember::getMembershipExpiry))
            .forEach(System.out::println);
        
        long expiringCount = members.stream()
            .filter(member -> member.getMembershipExpiry().isBefore(thirtyDaysFromNow) || 
                             member.getMembershipExpiry().isEqual(thirtyDaysFromNow))
            .count();
        
        System.out.println("\nTotal members with expiring memberships: " + expiringCount);
        
        System.out.println("\nUrgent renewals (within 7 days):");
        LocalDate sevenDaysFromNow = LocalDate.now().plusDays(7);
        
        members.stream()
            .filter(member -> member.getMembershipExpiry().isBefore(sevenDaysFromNow) || 
                             member.getMembershipExpiry().isEqual(sevenDaysFromNow))
            .forEach(member -> System.out.println("URGENT: " + member));
    }
}