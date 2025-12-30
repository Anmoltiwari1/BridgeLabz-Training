import java.util.Scanner;

// Counting Sort - Sort Student Ages
// Non-comparison based sorting for integers within a specific range
public class CountingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from user
        System.out.println("Enter number of students:");
        int n = sc.nextInt();
        int[] studentAges = new int[n];
        
        System.out.println("Enter student ages (10-18):");
        for(int i = 0; i < n; i++) {
            studentAges[i] = sc.nextInt();
        }
        
        // Display original array
        System.out.println("Student ages before sorting:");
        printArray(studentAges);
        
        // Sort the student ages
        countingSort(studentAges);
        
        // Display sorted array
        System.out.println("Student ages after sorting:");
        printArray(studentAges);

        sc.close();
    }
    
    // Counting sort algorithm for ages 10-18
    public static void countingSort(int[] arr) {
        int min = 10, max = 18; // Age range
        int range = max - min + 1;
        
        // Create count array to store frequency of each age
        int[] count = new int[range];
        int[] output = new int[arr.length];
        
        // Count frequency of each age
        for(int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        
        // Calculate cumulative count (positions)
        for(int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        
        // Build output array by placing elements at correct positions
        for(int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--; // Decrease count for next occurrence
        }
        
        // Copy sorted elements back to original array
        for(int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
    
    // Helper method to print array
    public static void printArray(int[] arr) {
        for(int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}