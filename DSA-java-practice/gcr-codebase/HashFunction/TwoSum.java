import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Enter target sum:");
        int target = sc.nextInt();

        int[] indices = twoSum(arr, target);
        if (indices != null)
            System.out.println("Indices: " + indices[0] + ", " + indices[1]);
        else
            System.out.println("No solution found.");
    }

    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement))
                return new int[]{map.get(complement), i};
            map.put(arr[i], i);
        }
        return null;
    }
}
