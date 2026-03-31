import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username = "john_doe";
    
    @JsonField(name = "user_age")
    private int age = 25;
    
    @JsonField(name = "user_email")
    private String email = "john@example.com";
    
    private String password = "secret123";
}

public class JsonFieldAnnotation {
    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{");
        
        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField jsonField = field.getAnnotation(JsonField.class);
                field.setAccessible(true);
                
                if (!first) {
                    json.append(",");
                }
                first = false;
                
                json.append("\"").append(jsonField.name()).append("\":");
                
                Object value = field.get(obj);
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
            }
        }
        
        json.append("}");
        return json.toString();
    }
    
    public static void main(String[] args) {
        try {
            User user = new User();
            String json = toJson(user);
            System.out.println("JSON: " + json);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}