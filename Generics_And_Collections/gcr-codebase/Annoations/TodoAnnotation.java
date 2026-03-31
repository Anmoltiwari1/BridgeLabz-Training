import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectManager {
    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void loginFeature() {
        System.out.println("Login feature pending");
    }
    
    @Todo(task = "Add unit tests", assignedTo = "Bob")
    public void addTests() {
        System.out.println("Tests pending");
    }
    
    @Todo(task = "Update documentation", assignedTo = "Charlie", priority = "LOW")
    public void updateDocs() {
        System.out.println("Documentation pending");
    }
}

public class TodoAnnotation {
    public static void main(String[] args) {
        Class<?> clazz = ProjectManager.class;
        
        System.out.println("=== Pending Tasks ===");
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("---");
            }
        }
    }
}