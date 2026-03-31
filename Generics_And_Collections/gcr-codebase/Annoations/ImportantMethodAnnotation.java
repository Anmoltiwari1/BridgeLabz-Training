import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {
    @ImportantMethod(level = "HIGH")
    public void criticalOperation() {
        System.out.println("Critical operation executed");
    }
    
    @ImportantMethod(level = "MEDIUM")
    public void normalOperation() {
        System.out.println("Normal operation executed");
    }
    
    public void regularMethod() {
        System.out.println("Regular method");
    }
}

public class ImportantMethodAnnotation {
    public static void main(String[] args) {
        Class<?> clazz = Service.class;
        
        System.out.println("=== Important Methods ===");
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + " | Level: " + annotation.level());
            }
        }
    }
}