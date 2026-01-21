import java.util.Scanner;

// Merge Sort - Sort Book Prices
// Divide and conquer approach that splits array and merges sorted halves
public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from user
        System.out.println("Enter number of books:");
        int n = sc.nextInt();
        double[] bookPrices = new double[n];
        
        System.out.println("Enter book prices:");
        for(int i = 0; i < n; i++) {
            bookPrices[i] = sc.nextDouble();
        }
        
        // Display original array
        System.out.println("Book prices before sorting:");
        printArray(bookPrices);
        
        // Sort the book prices
        mergeSort(bookPrices, 0, bookPrices.length - 1);
        
        // Display sorted array
        System.out.println("Book prices after sorting:");
        printArray(bookPrices);

        sc.close();
    }
    
    // Main merge sort function - divides array recursively
    public static void mergeSort(double[] arr, int left, int right) {
        if(left < right) {
            // Find the middle point to divide array into two halves
            int mid = left + (right - left) / 2;
            
            // Recursively sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);

        }
    }
    
    // Merges two sorted subarrays into one sorted array
    public static void merge(double[] arr, int left, int mid, int right) {
        // Calculate sizes of two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temporary arrays
        double[] leftArr = new double[n1];
        double[] rightArr = new double[n2];
        
        // Copy data to temporary arrays
        for(int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for(int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }
        
        // Merge the temporary arrays back into original array
        int i = 0, j = 0, k = left;
        
        // Compare elements and merge in sorted order
        while(i < n1 && j < n2) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of leftArr, if any
        while(i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of rightArr, if any
        while(j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    // Helper method to print array
    public static void printArray(double[] arr) {
        for(double value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}