import java.util.*;

public class SetEquality {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Are equal: " + areEqual(set1, set2));
    }
    
    static boolean areEqual(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2);
    }
}