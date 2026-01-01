public class FibonacciPerformanceComparison {
    public static void main(String[] args) {
        int[] values = {10, 20, 30, 35}; // Limited for recursive feasibility
        
        for (int n : values) {
            System.out.println("\n=== Fibonacci(" + n + ") ===");
            
            // Recursive approach
            long startTime = System.nanoTime();
            long result1 = fibonacciRecursive(n);
            long recursiveTime = System.nanoTime() - startTime;
            
            // Iterative approach
            startTime = System.nanoTime();
            long result2 = fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - startTime;
            
            System.out.println("Result: " + result1 + " (both methods should match)");
            System.out.println("Recursive: " + recursiveTime / 1000000.0 + " ms");
            System.out.println("Iterative: " + iterativeTime / 1000000.0 + " ms");
            
            if (iterativeTime > 0) {
                System.out.println("Iterative is " + (recursiveTime / iterativeTime) + "x faster");
            }
        }
    }
    
    public static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    public static long fibonacciIterative(int n) {
        if (n <= 1) return n;
        
        long a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}