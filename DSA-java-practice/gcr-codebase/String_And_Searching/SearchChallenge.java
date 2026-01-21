import java.util.*;

public class SearchChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Linear Search for first missing positive
        int missingPositive = findFirstMissingPositive(arr);
        System.out.println("First missing positive: " + missingPositive);
        
        // Binary Search for target
        Arrays.sort(arr);
        System.out.print("Enter target to search: ");
        int target = sc.nextInt();
        
        int index = binarySearch(arr, target);
        if (index != -1) {
            System.out.println("Target found at index: " + index);
        } else {
            System.out.println("Target not found");
        }
        sc.close();
    }
    
    public static int findFirstMissingPositive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (num > 0) {
                set.add(num);
            }
        }
        
        for (int i = 1; i <= arr.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return arr.length + 1;
    }
    
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}