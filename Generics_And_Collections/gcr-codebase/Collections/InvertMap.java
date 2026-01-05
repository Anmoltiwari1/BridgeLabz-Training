import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("A", 1);
        original.put("B", 2);
        original.put("C", 1);
        
        System.out.println("Original Map: " + original);
        Map<Integer, List<String>> inverted = invertMap(original);
        System.out.println("Inverted Map: " + inverted);
    }
    
    static Map<Integer, List<String>> invertMap(Map<String, Integer> original) {
        Map<Integer, List<String>> inverted = new HashMap<>();
        
        for (Map.Entry<String, Integer> entry : original.entrySet()) {
            Integer value = entry.getValue();
            String key = entry.getKey();
            
            inverted.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        
        return inverted;
    }
}