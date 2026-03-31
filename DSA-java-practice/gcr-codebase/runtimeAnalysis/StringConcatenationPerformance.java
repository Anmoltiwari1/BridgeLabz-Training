public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000}; // Reduced for String feasibility
        
        for (int size : sizes) {
            System.out.println("\n=== Operations Count: " + size + " ===");
            
            // String concatenation (inefficient)
            long startTime = System.nanoTime();
            String result1 = "";
            for (int i = 0; i < size; i++) {
                result1 += "hello";
            }
            long stringTime = System.nanoTime() - startTime;
            
            // StringBuilder
            startTime = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append("hello");
            }
            String result2 = sb.toString();
            long sbTime = System.nanoTime() - startTime;
            
            // StringBuffer
            startTime = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < size; i++) {
                sbf.append("hello");
            }
            String result3 = sbf.toString();
            long sbfTime = System.nanoTime() - startTime;
            
            System.out.println("String: " + stringTime / 1000000.0 + " ms");
            System.out.println("StringBuilder: " + sbTime / 1000000.0 + " ms");
            System.out.println("StringBuffer: " + sbfTime / 1000000.0 + " ms");
            System.out.println("StringBuilder is " + (stringTime / sbTime) + "x faster than String");
        }
    }
}