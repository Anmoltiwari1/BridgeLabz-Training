public class DateFormatterTest {
    public static void main(String[] args) {
        testValidDateFormat();
        testInvalidDateFormat();
        System.out.println("All DateFormatter tests completed!");
    }
    
    static void testValidDateFormat() {
        DateFormatter formatter = new DateFormatter();
        String result = formatter.formatDate("2023-12-25");
        
        if ("25-12-2023".equals(result)) {
            System.out.println("✅ testValidDateFormat passed");
        } else {
            System.out.println("❌ testValidDateFormat failed");
        }
    }
    
    static void testInvalidDateFormat() {
        DateFormatter formatter = new DateFormatter();
        
        try {
            formatter.formatDate("25-12-2023");
            System.out.println("❌ testInvalidDateFormat failed - no exception thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ testInvalidDateFormat passed - exception caught: " + e.getMessage());
        }
    }
}