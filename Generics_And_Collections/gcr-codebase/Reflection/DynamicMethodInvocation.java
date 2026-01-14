import java.lang.reflect.*;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter method name (add/subtract/multiply):");
        String methodName = sc.nextLine();
        
        System.out.println("Enter first number:");
        int a = sc.nextInt();
        System.out.println("Enter second number:");
        int b = sc.nextInt();
        
        try {
            MathOperations math = new MathOperations();
            Class<?> clazz = math.getClass();
            
            Method method = clazz.getMethod(methodName, int.class, int.class);
            Object result = method.invoke(math, a, b);
            
            System.out.println("Result: " + result);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}