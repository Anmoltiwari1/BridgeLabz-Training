import java.util.*;

public class SubArraySumZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<List<Integer>> zeroSumSubarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero-sum subarrays:");
        for (List<Integer> subarray : zeroSumSubarrays) {
            System.out.println(subarray);
        }
    }

    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        // Map from prefix sum to list of indices where that sum occurs
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        // Initialize map with sum 0 at index -1 to handle subarrays starting at index 0
        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum has been seen before, zero-sum subarray exists
            if (map.containsKey(sum)) {
                List<Integer> startIndices = map.get(sum);
                for (int start : startIndices) {
                    // subarray from start+1 to i has sum zero
                    List<Integer> subarray = new ArrayList<>();
                    for (int k = start + 1; k <= i; k++) {
                        subarray.add(arr[k]);
                    }
                    result.add(subarray);
                }
            }

            // Add current index to map
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return result;
    }
}
