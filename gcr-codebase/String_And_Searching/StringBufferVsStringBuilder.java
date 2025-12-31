public class StringBufferVsStringBuilder {
    public static void main(String[] args) {
        int iterations = 1000000;
        String testString = "hello";
        
        // Test StringBuffer
        long startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append(testString);
        }
        long stringBufferTime = System.nanoTime() - startTime;
        
        // Test StringBuilder
        startTime = System.nanoTime();
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbuilder.append(testString);
        }
        long stringBuilderTime = System.nanoTime() - startTime;
        
        System.out.println("StringBuffer time: " + stringBufferTime + " nanoseconds");
        System.out.println("StringBuilder time: " + stringBuilderTime + " nanoseconds");
        System.out.println("StringBuilder is " + (stringBufferTime / stringBuilderTime) + "x faster");
    }
}