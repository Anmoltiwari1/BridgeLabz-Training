public class ParameterizedTest {
    public static void main(String[] args) {
        testIsEvenWithMultipleValues();
        System.out.println("Parameterized tests completed!");
    }
    
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    static void testIsEvenWithMultipleValues() {
        int[] evenNumbers = {2, 4, 6, 8, 10};
        int[] oddNumbers = {1, 3, 5, 7, 9};
        
        for (int num : evenNumbers) {
            if (isEven(num)) {
                System.out.println("✅ isEven(" + num + ") passed");
            } else {
                System.out.println("❌ isEven(" + num + ") failed");
            }
        }
        
        for (int num : oddNumbers) {
            if (!isEven(num)) {
                System.out.println("✅ isEven(" + num + ") passed (correctly odd)");
            } else {
                System.out.println("❌ isEven(" + num + ") failed");
            }
        }
    }
}