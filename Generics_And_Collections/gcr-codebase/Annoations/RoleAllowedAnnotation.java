import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AdminService {
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully");
    }
    
    @RoleAllowed("ADMIN")
    public void viewLogs() {
        System.out.println("Viewing system logs");
    }
    
    public void publicMethod() {
        System.out.println("Public method accessible to all");
    }
}

public class RoleAllowedAnnotation {
    private static String currentUserRole = "USER";
    
    public static void executeWithRoleCheck(Object obj, String methodName) throws Exception {
        Class<?> clazz = obj.getClass();
        Method method = clazz.getMethod(methodName);
        
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            
            if (currentUserRole.equals(roleAllowed.value())) {
                method.invoke(obj);
            } else {
                System.out.println("❌ Access Denied! Required role: " + roleAllowed.value());
            }
        } else {
            method.invoke(obj);
        }
    }
    
    public static void main(String[] args) {
        try {
            AdminService service = new AdminService();
            
            System.out.println("Current user role: " + currentUserRole);
            executeWithRoleCheck(service, "deleteUser");
            executeWithRoleCheck(service, "publicMethod");
            
            System.out.println("\nChanging role to ADMIN");
            currentUserRole = "ADMIN";
            executeWithRoleCheck(service, "deleteUser");
            executeWithRoleCheck(service, "viewLogs");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}