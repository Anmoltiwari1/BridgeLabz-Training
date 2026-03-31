import java.util.*;

public class SortingPerformanceComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000}; // Reduced for bubble sort feasibility
        
        for (int size : sizes) {
            System.out.println("\n=== Dataset Size: " + size + " ===");
            
            // Generate random array
            int[] original = new int[size];
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                original[i] = rand.nextInt(size);
            }
            
            // Bubble Sort
            int[] arr1 = original.clone();
            long startTime = System.nanoTime();
            bubbleSort(arr1);
            long bubbleTime = System.nanoTime() - startTime;
            
            // Merge Sort
            int[] arr2 = original.clone();
            startTime = System.nanoTime();
            mergeSort(arr2, 0, arr2.length - 1);
            long mergeTime = System.nanoTime() - startTime;
            
            // Quick Sort
            int[] arr3 = original.clone();
            startTime = System.nanoTime();
            quickSort(arr3, 0, arr3.length - 1);
            long quickTime = System.nanoTime() - startTime;
            
            System.out.println("Bubble Sort: " + bubbleTime / 1000000.0 + " ms");
            System.out.println("Merge Sort: " + mergeTime / 1000000.0 + " ms");
            System.out.println("Quick Sort: " + quickTime / 1000000.0 + " ms");
        }
    }
    
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        
        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}