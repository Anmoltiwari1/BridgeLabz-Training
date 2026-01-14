import java.lang.reflect.*;

class Student {
    private String name;
    
    public Student() {
        this.name = "Unknown";
    }
    
    public void display() {
        System.out.println("Student: " + name);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("Student");
            Object obj = clazz.getDeclaredConstructor().newInstance();
            
            Method displayMethod = clazz.getMethod("display");
            displayMethod.invoke(obj);
            
            System.out.println("Object created dynamically: " + obj.getClass().getName());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}