import java.util.Scanner;

public class BinarySearchRotationPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter rotated sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int rotationPoint = findRotationPoint(arr);
        System.out.println("Rotation point (smallest element) index: " + rotationPoint);
        System.out.println("Smallest element: " + arr[rotationPoint]);
        sc.close();
    }
    
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}