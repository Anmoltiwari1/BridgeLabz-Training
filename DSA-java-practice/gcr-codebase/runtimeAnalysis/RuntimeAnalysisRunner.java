public class RuntimeAnalysisRunner {
    public static void main(String[] args) {
        System.out.println("=== COMPREHENSIVE RUNTIME ANALYSIS ===\n");
        
        System.out.println("1. SEARCH PERFORMANCE COMPARISON");
        System.out.println("Comparing Linear Search O(N) vs Binary Search O(log N)");
        SearchPerformanceComparison.main(args);
        
        System.out.println("\n\n2. SORTING PERFORMANCE COMPARISON");
        System.out.println("Comparing Bubble Sort O(N²) vs Merge Sort O(N log N) vs Quick Sort O(N log N)");
        SortingPerformanceComparison.main(args);
        
        System.out.println("\n\n3. STRING CONCATENATION PERFORMANCE");
        System.out.println("Comparing String O(N²) vs StringBuilder O(N) vs StringBuffer O(N)");
        StringConcatenationPerformance.main(args);
        
        System.out.println("\n\n4. FILE READING PERFORMANCE");
        System.out.println("Comparing FileReader vs InputStreamReader");
        FileReadingPerformance.main(args);
        
        System.out.println("\n\n5. FIBONACCI COMPUTATION PERFORMANCE");
        System.out.println("Comparing Recursive O(2ⁿ) vs Iterative O(N)");
        FibonacciPerformanceComparison.main(args);
        
        System.out.println("\n\n6. DATA STRUCTURE SEARCH PERFORMANCE");
        System.out.println("Comparing Array O(N) vs HashSet O(1) vs TreeSet O(log N)");
        DataStructureSearchPerformance.main(args);
        
        System.out.println("\n\n=== ANALYSIS COMPLETE ===");
        System.out.println("Key Takeaways:");
        System.out.println("• Binary Search >> Linear Search for large sorted datasets");
        System.out.println("• Merge/Quick Sort >> Bubble Sort for large datasets");
        System.out.println("• StringBuilder/StringBuffer >> String for concatenation");
        System.out.println("• InputStreamReader >= FileReader for large files");
        System.out.println("• Iterative >> Recursive for Fibonacci computation");
        System.out.println("• HashSet >> TreeSet >> Array for search operations");
    }
}