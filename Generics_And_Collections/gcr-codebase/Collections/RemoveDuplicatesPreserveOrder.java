import java.util.*;

public class RemoveDuplicatesPreserveOrder {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println("Input: " + list);
        
        List<Integer> result = removeDuplicates(list);
        System.out.println("Output: " + result);
    }
    
    static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new LinkedHashSet<>();
        for (Integer item : list) {
            seen.add(item);
        }
        return new ArrayList<>(seen);
    }
}