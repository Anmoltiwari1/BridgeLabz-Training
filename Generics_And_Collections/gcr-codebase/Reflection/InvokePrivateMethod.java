import java.lang.reflect.*;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            Class<?> clazz = calc.getClass();
            
            Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true);
            
            Object result = multiplyMethod.invoke(calc, 5, 3);
            System.out.println("Result: " + result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}