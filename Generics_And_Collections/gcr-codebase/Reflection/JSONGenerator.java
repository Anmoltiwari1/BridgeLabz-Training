import java.lang.reflect.*;

class Product {
    private String name = "Laptop";
    private double price = 999.99;
    private int quantity = 5;
}

public class JSONGenerator {
    public static String toJSON(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{");
        
        Field[] fields = clazz.getDeclaredFields();
        
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            
            json.append("\"").append(field.getName()).append("\":");
            
            Object value = field.get(obj);
            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }
            
            if (i < fields.length - 1) {
                json.append(",");
            }
        }
        
        json.append("}");
        return json.toString();
    }
    
    public static void main(String[] args) {
        try {
            Product product = new Product();
            String json = toJSON(product);
            System.out.println("JSON: " + json);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}