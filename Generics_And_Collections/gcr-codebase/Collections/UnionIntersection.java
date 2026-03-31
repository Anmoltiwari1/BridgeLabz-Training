import java.util.*;

public class UnionIntersection {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Union: " + union(set1, set2));
        System.out.println("Intersection: " + intersection(set1, set2));
    }
    
    static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
    
    static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }
}