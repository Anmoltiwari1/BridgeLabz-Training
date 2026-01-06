public class MultipleTryCatch {
    
    public static void main(String[] args) {
        
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero error");
        }
        
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error");
        }
        
        try {
            System.out.println(Integer.parseInt("abc"));
        } catch (NumberFormatException e) {
            System.out.println("Number format error");
        }
        
        try {
            int a = 10;
            int b = 0;
            int result = a / b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Math error");
        } catch (Exception e) {
            System.out.println("Other error");
        }
    }
}