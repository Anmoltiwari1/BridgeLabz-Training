import java.lang.reflect.*;

class Person {
    private int age = 25;
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            Class<?> clazz = person.getClass();
            
            Field ageField = clazz.getDeclaredField("age");
            ageField.setAccessible(true);
            
            System.out.println("Original age: " + ageField.get(person));
            
            ageField.set(person, 30);
            System.out.println("Modified age: " + ageField.get(person));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}