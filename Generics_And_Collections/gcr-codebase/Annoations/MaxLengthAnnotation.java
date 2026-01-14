import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;
    
    public User(String username) throws Exception {
        validateFields();
        this.username = username;
        validateFields();
    }
    
    private void validateFields() throws Exception {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                field.setAccessible(true);
                
                Object value = field.get(this);
                if (value instanceof String) {
                    String strValue = (String) value;
                    if (strValue != null && strValue.length() > maxLength.value()) {
                        throw new IllegalArgumentException(
                            field.getName() + " exceeds max length of " + maxLength.value()
                        );
                    }
                }
            }
        }
    }
    
    public String getUsername() {
        return username;
    }
}

public class MaxLengthAnnotation {
    public static void main(String[] args) {
        try {
            User user1 = new User("john");
            System.out.println("✅ Valid username: " + user1.getUsername());
            
            User user2 = new User("verylongusername");
            System.out.println("✅ Valid username: " + user2.getUsername());
            
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation failed: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}