import java.util.Scanner;

// Selection Sort - Sort Exam Scores
// Finds the minimum element and places it at the beginning
public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from user
        System.out.println("Enter number of students:");
        int n = sc.nextInt();
        int[] examScores = new int[n];
        
        System.out.println("Enter exam scores:");
        for(int i = 0; i < n; i++) {
            examScores[i] = sc.nextInt();
        }
        
        // Display original array
        System.out.println("Exam scores before sorting:");
        printArray(examScores);
        
        // Sort the scores
        selectionSort(examScores);
        
        // Display sorted array
        System.out.println("Exam scores after sorting:");
        printArray(examScores);

        sc.close();
    }
    
    // Selection sort algorithm
    public static void selectionSort(int[] arr) {
        // Move boundary of unsorted subarray one by one
        for(int i = 0; i < arr.length - 1; i++) {
            // Find the minimum element in remaining unsorted array
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j; // Update minimum index
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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