public class ExceptionTest {
    public static void main(String[] args) {
        testDivisionByZero();
        System.out.println("Exception test completed!");
    }
    
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
    
    static void testDivisionByZero() {
        try {
            divide(10, 0);
            System.out.println("❌ testDivisionByZero failed - no exception thrown");
        } catch (ArithmeticException e) {
            System.out.println("✅ testDivisionByZero passed - exception caught: " + e.getMessage());
        }
    }
}