import java.util.*;

public class SearchPerformanceComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        
        for (int size : sizes) {
            System.out.println("\n=== Dataset Size: " + size + " ===");
            
            // Generate sorted array
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = i;
            }
            
            int target = size - 1; // Search for last element
            
            // Linear Search
            long startTime = System.nanoTime();
            linearSearch(arr, target);
            long linearTime = System.nanoTime() - startTime;
            
            // Binary Search
            startTime = System.nanoTime();
            binarySearch(arr, target);
            long binaryTime = System.nanoTime() - startTime;
            
            System.out.println("Linear Search: " + linearTime / 1000000.0 + " ms");
            System.out.println("Binary Search: " + binaryTime / 1000000.0 + " ms");
            System.out.println("Binary Search is " + (linearTime / binaryTime) + "x faster");
        }
    }
    
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
    
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}