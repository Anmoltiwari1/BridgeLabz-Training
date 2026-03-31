import java.util.*;

public class FindSubsets {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Is Set1 subset of Set2: " + isSubset(set1, set2));
    }
    
    static boolean isSubset(Set<Integer> subset, Set<Integer> superset) {
        return superset.containsAll(subset);
    }
}