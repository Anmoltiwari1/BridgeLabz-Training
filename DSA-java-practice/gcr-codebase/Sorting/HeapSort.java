import java.util.Scanner;

// Heap Sort - Sort Job Applicant Salaries
// Uses binary heap data structure to sort elements
public class HeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from user
        System.out.println("Enter number of job applicants:");
        int n = sc.nextInt();
        int[] salaryDemands = new int[n];
        
        System.out.println("Enter salary demands:");
        for(int i = 0; i < n; i++) {
            salaryDemands[i] = sc.nextInt();
        }
        
        // Display original array
        System.out.println("Salary demands before sorting:");
        printArray(salaryDemands);
        
        // Sort the salary demands
        heapSort(salaryDemands);
        
        // Display sorted array
        System.out.println("Salary demands after sorting:");
        printArray(salaryDemands);

        sc.close();
    }
    
    // Main heap sort function
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build max heap from array (rearrange array)
        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // Extract elements from heap one by one
        for(int i = n - 1; i > 0; i--) {
            // Move current root to end (largest element)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    
    // Maintains the max heap property
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child
        
        // If left child is larger than root
        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // If right child is larger than largest so far
        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // If largest is not root, swap and continue heapifying
        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
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