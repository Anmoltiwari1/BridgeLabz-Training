import java.lang.reflect.*;
import java.util.Scanner;

public class GetClassInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter class name (e.g., java.lang.String):");
        String className = sc.nextLine();
        
        try {
            Class<?> clazz = Class.forName(className);
            
            System.out.println("\n=== Methods ===");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(method.getName());
            }
            
            System.out.println("\n=== Fields ===");
            for (Field field : clazz.getDeclaredFields()) {
                System.out.println(field.getName());
            }
            
            System.out.println("\n=== Constructors ===");
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                System.out.println(constructor);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}