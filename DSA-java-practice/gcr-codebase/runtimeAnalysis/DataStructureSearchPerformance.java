import java.util.*;

public class DataStructureSearchPerformance {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        
        for (int size : sizes) {
            System.out.println("\n=== Dataset Size: " + size + " ===");
            
            // Prepare data
            Integer[] array = new Integer[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                int value = rand.nextInt(size * 2);
                array[i] = value;
                hashSet.add(value);
                treeSet.add(value);
            }
            
            int target = array[size - 1]; // Search for last element
            
            // Array Linear Search
            long startTime = System.nanoTime();
            boolean found1 = arraySearch(array, target);
            long arrayTime = System.nanoTime() - startTime;
            
            // HashSet Search
            startTime = System.nanoTime();
            boolean found2 = hashSet.contains(target);
            long hashTime = System.nanoTime() - startTime;
            
            // TreeSet Search
            startTime = System.nanoTime();
            boolean found3 = treeSet.contains(target);
            long treeTime = System.nanoTime() - startTime;
            
            System.out.println("Array Search: " + arrayTime / 1000000.0 + " ms");
            System.out.println("HashSet Search: " + hashTime / 1000000.0 + " ms");
            System.out.println("TreeSet Search: " + treeTime / 1000000.0 + " ms");
            
            if (hashTime > 0) {
                System.out.println("HashSet is " + (arrayTime / hashTime) + "x faster than Array");
            }
        }
    }
    
    public static boolean arraySearch(Integer[] array, int target) {
        for (Integer value : array) {
            if (value.equals(target)) {
                return true;
            }
        }
        return false;
    }
}