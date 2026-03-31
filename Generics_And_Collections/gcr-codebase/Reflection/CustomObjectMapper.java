import java.lang.reflect.*;
import java.util.*;

class User {
    private String name;
    private int age;
    private String email;
    
    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            try {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(obj, entry.getValue());
            } catch (NoSuchFieldException e) {
                System.out.println("Field not found: " + entry.getKey());
            }
        }
        
        return obj;
    }
    
    public static void main(String[] args) {
        try {
            Map<String, Object> properties = new HashMap<>();
            properties.put("name", "Alice");
            properties.put("age", 28);
            properties.put("email", "alice@example.com");
            
            User user = toObject(User.class, properties);
            System.out.println(user);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}