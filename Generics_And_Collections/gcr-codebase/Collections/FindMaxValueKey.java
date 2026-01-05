import java.util.*;

public class FindMaxValueKey {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        
        System.out.println("Input Map: " + map);
        String maxKey = findKeyWithMaxValue(map);
        System.out.println("Key with highest value: " + maxKey);
    }
    
    static String findKeyWithMaxValue(Map<String, Integer> map) {
        if (map.isEmpty()) return null;
        
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}