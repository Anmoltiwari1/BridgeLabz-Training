import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

class Database {
    public void connect() {
        System.out.println("Database connected");
    }
}

class UserService {
    @Inject
    private Database database;
    
    public void performOperation() {
        if (database != null) {
            database.connect();
            System.out.println("UserService operation performed");
        } else {
            System.out.println("Database not injected");
        }
    }
}

public class DependencyInjection {
    public static void inject(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = field.getType().getDeclaredConstructor().newInstance();
                field.set(obj, dependency);
                System.out.println("Injected: " + field.getType().getSimpleName());
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            UserService service = new UserService();
            inject(service);
            service.performOperation();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}