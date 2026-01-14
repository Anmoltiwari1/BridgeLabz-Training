import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class Calculator {
    @CacheResult
    public int fibonacci(int n) {
        System.out.println("Computing fibonacci(" + n + ")");
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    @CacheResult
    public int factorial(int n) {
        System.out.println("Computing factorial(" + n + ")");
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}

public class CacheResultAnnotation {
    private static Map<String, Object> cache = new HashMap<>();
    
    public static Object executeWithCache(Object obj, String methodName, Object... args) throws Exception {
        Class<?> clazz = obj.getClass();
        Class<?>[] paramTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            paramTypes[i] = args[i].getClass();
            if (paramTypes[i] == Integer.class) paramTypes[i] = int.class;
        }
        
        Method method = clazz.getMethod(methodName, paramTypes);
        
        if (method.isAnnotationPresent(CacheResult.class)) {
            String cacheKey = methodName + Arrays.toString(args);
            
            if (cache.containsKey(cacheKey)) {
                System.out.println("✅ Returning cached result for " + cacheKey);
                return cache.get(cacheKey);
            }
            
            Object result = method.invoke(obj, args);
            cache.put(cacheKey, result);
            return result;
        }
        
        return method.invoke(obj, args);
    }
    
    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            
            System.out.println("First call:");
            Object result1 = executeWithCache(calc, "factorial", 5);
            System.out.println("Result: " + result1);
            
            System.out.println("\nSecond call (should use cache):");
            Object result2 = executeWithCache(calc, "factorial", 5);
            System.out.println("Result: " + result2);
            
            System.out.println("\nDifferent input:");
            Object result3 = executeWithCache(calc, "factorial", 6);
            System.out.println("Result: " + result3);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}