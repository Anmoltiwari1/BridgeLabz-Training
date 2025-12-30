import java.util.Scanner;

// Insertion Sort - Sort Employee IDs
// Builds the sorted array one element at a time
public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from user
        System.out.println("Enter number of employees:");
        int n = sc.nextInt();
        int[] employeeIds = new int[n];
        
        System.out.println("Enter employee IDs:");
        for(int i = 0; i < n; i++) {
            employeeIds[i] = sc.nextInt();
        }
        
        // Display original array
        System.out.println("Employee IDs before sorting:");
        printArray(employeeIds);
        
        // Sort the employee IDs
        insertionSort(employeeIds);
        
        // Display sorted array
        System.out.println("Employee IDs after sorting:");
        printArray(employeeIds);
        
        sc.close();
    }
    
    // Insertion sort algorithm
    public static void insertionSort(int[] arr) {
        // Start from second element (first is already "sorted")
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i]; // Current element to be positioned
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Place key at its correct position
            arr[j + 1] = key;
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