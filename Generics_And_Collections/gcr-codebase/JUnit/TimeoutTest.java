public class TimeoutTest {
    public static void main(String[] args) {
        testLongRunningTask();
        System.out.println("Timeout test completed!");
    }
    
    public static String longRunningTask() {
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task completed";
    }
    
    static void testLongRunningTask() {
        long startTime = System.currentTimeMillis();
        
        try {
            String result = longRunningTask();
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            
            if (duration > 2000) {
                System.out.println("❌ Task took " + duration + "ms - exceeds 2 second timeout");
            } else {
                System.out.println("✅ Task completed within timeout: " + result);
            }
        } catch (Exception e) {
            System.out.println("❌ Task failed: " + e.getMessage());
        }
    }
}