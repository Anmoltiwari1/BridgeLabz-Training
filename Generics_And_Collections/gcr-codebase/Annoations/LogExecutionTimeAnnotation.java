import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformanceTest {
    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++) {
            Math.sqrt(i);
        }
    }
    
    @LogExecutionTime
    public void slowMethod() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class LogExecutionTimeAnnotation {
    public static void executeWithTiming(Object obj, String methodName) throws Exception {
        Class<?> clazz = obj.getClass();
        Method method = clazz.getMethod(methodName);
        
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();
            
            long duration = (endTime - startTime) / 1_000_000;
            System.out.println(methodName + " execution time: " + duration + " ms");
        }
    }
    
    public static void main(String[] args) {
        try {
            PerformanceTest test = new PerformanceTest();
            
            executeWithTiming(test, "fastMethod");
            executeWithTiming(test, "slowMethod");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}