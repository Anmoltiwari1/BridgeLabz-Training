import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "default_key_123";
}

public class AccessStaticField {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Configuration.class;
            
            Field apiKeyField = clazz.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true);
            
            System.out.println("Original API_KEY: " + apiKeyField.get(null));
            
            apiKeyField.set(null, "new_secret_key_456");
            System.out.println("Modified API_KEY: " + apiKeyField.get(null));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}