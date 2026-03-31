import java.io.*;
import java.util.*;

class Person {
    private String name;
    private int age;
    private String email;
    
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    public String toJSON() {
        return "{\"name\": \"" + name + "\", \"age\": " + age + ", \"email\": \"" + email + "\"}";
    }
}

public class ObjectsToJSON {
    public static String convertToJSONArray(List<Person> persons) {
        StringBuilder json = new StringBuilder("[\n");
        
        for (int i = 0; i < persons.size(); i++) {
            json.append("  ").append(persons.get(i).toJSON());
            if (i < persons.size() - 1) {
                json.append(",");
            }
            json.append("\n");
        }
        
        json.append("]");
        return json.toString();
    }
    
    public static void writeJSONToFile(String filename, String jsonContent) {
        try (PrintWriter pw = new PrintWriter(filename)) {
            pw.println(jsonContent);
            System.out.println("JSON array written to: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 25, "alice@example.com"));
        persons.add(new Person("Bob", 30, "bob@example.com"));
        persons.add(new Person("Charlie", 28, "charlie@example.com"));
        
        String jsonArray = convertToJSONArray(persons);
        
        System.out.println("Generated JSON Array:");
        System.out.println(jsonArray);
        
        writeJSONToFile("persons.json", jsonArray);
    }
}