import java.lang.reflect.*;

class TestClass {
    public void fastMethod() {
        System.out.println("Fast method executed");
    }
    
    public void slowMethod() {
        try {
            Thread.sleep(1000);
            System.out.println("Slow method executed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MethodExecutionTiming {
    public static void measureExecutionTime(Object obj, String methodName) throws Exception {
        Class<?> clazz = obj.getClass();
        Method method = clazz.getMethod(methodName);
        
        long startTime = System.currentTimeMillis();
        method.invoke(obj);
        long endTime = System.currentTimeMillis();
        
        System.out.println("Method " + methodName + " took " + (endTime - startTime) + " ms");
    }
    
    public static void main(String[] args) {
        try {
            TestClass test = new TestClass();
            
            measureExecutionTime(test, "fastMethod");
            measureExecutionTime(test, "slowMethod");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}