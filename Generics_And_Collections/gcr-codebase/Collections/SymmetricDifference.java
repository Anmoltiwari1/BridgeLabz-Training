import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
    }
    
    static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        Set<Integer> temp = new HashSet<>(set2);
        
        result.removeAll(set2);  // Elements in set1 but not in set2
        temp.removeAll(set1);    // Elements in set2 but not in set1
        result.addAll(temp);     // Combine both
        
        return result;
    }
}