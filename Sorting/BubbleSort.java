//package Sorting;
import java.util.Scanner;

// Bubble Sort - Sort Array Elements
// Repeatedly swaps adjacent elements if they are in wrong order
public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from user
        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements of array");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Display original array
        System.out.println("Array before sorting:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Sort the array
        bubbleSort(arr, n);

        // Display sorted array
        System.out.println("\nArray after sorting:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
    
    // Bubble sort algorithm
    public static void bubbleSort(int[] arr, int n) {
        // Outer loop for number of passes
        for(int i = 0; i < n - 1; i++) {
            // Inner loop for comparisons in each pass
            // After each pass, largest element bubbles to the end
            for(int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if(arr[j] > arr[j + 1]) {
                    // Swap if they are in wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
