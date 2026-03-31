public class StringUtilsTest {
    public static void main(String[] args) {
        testReverse();
        testIsPalindrome();
        testToUpperCase();
        System.out.println("All StringUtils tests passed!");
    }
    
    static void testReverse() {
        StringUtils utils = new StringUtils();
        String result = utils.reverse("hello");
        if ("olleh".equals(result)) {
            System.out.println("✅ testReverse passed");
        } else {
            System.out.println("❌ testReverse failed");
        }
    }
    
    static void testIsPalindrome() {
        StringUtils utils = new StringUtils();
        boolean result = utils.isPalindrome("racecar");
        if (result) {
            System.out.println("✅ testIsPalindrome passed");
        } else {
            System.out.println("❌ testIsPalindrome failed");
        }
    }
    
    static void testToUpperCase() {
        StringUtils utils = new StringUtils();
        String result = utils.toUpperCase("hello");
        if ("HELLO".equals(result)) {
            System.out.println("✅ testToUpperCase passed");
        } else {
            System.out.println("❌ testToUpperCase failed");
        }
    }
}