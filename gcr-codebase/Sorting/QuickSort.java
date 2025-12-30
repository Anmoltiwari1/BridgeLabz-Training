import java.util.Scanner;

// Quick Sort - Sort Product Prices
// Uses divide and conquer with pivot partitioning
public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from user
        System.out.println("Enter number of products:");
        int n = sc.nextInt();
        double[] productPrices = new double[n];
        
        System.out.println("Enter product prices:");
        for(int i = 0; i < n; i++) {
            productPrices[i] = sc.nextDouble();
        }
        
        // Display original array
        System.out.println("Product prices before sorting:");
        printArray(productPrices);
        
        // Sort the product prices
        quickSort(productPrices, 0, productPrices.length - 1);
        
        // Display sorted array
        System.out.println("Product prices after sorting:");
        printArray(productPrices);

        sc.close();
    }
    
    // Main quick sort function
    public static void quickSort(double[] arr, int low, int high) {
        if(low < high) {
            // Partition the array and get pivot index
            int pi = partition(arr, low, high);
            
            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    // Partitions array around pivot (last element)
    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high]; // Choose last element as pivot
        int i = low - 1; // Index of smaller element
        
        // Rearrange array so smaller elements are on left of pivot
        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // Place pivot in correct position
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    // Helper method to swap two elements
    public static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Helper method to print array
    public static void printArray(double[] arr) {
        for(double value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}