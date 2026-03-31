import java.io.*;
import java.util.*;

public class JSONFilter {
    public static void filterUsersOlderThan25(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }
            
            String json = jsonContent.toString().trim();
            
            if (json.startsWith("[") && json.endsWith("]")) {
                json = json.substring(1, json.length() - 1);
                String[] users = splitUsers(json);
                
                System.out.println("Users older than 25:");
                for (String user : users) {
                    int age = extractAge(user);
                    if (age > 25) {
                        String name = extractName(user);
                        System.out.println("Name: " + name + ", Age: " + age);
                    }
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }
    
    private static String[] splitUsers(String json) {
        List<String> users = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int braceCount = 0;
        boolean inQuotes = false;
        
        for (char c : json.toCharArray()) {
            if (c == '"') inQuotes = !inQuotes;
            if (!inQuotes) {
                if (c == '{') braceCount++;
                if (c == '}') braceCount--;
            }
            
            current.append(c);
            
            if (braceCount == 0 && current.toString().trim().endsWith("}")) {
                users.add(current.toString().trim());
                current = new StringBuilder();
            }
        }
        
        return users.toArray(new String[0]);
    }
    
    private static int extractAge(String userJson) {
        String[] parts = userJson.split(",");
        for (String part : parts) {
            if (part.contains("age")) {
                String[] agePart = part.split(":");
                if (agePart.length > 1) {
                    return Integer.parseInt(agePart[1].trim().replaceAll("[^0-9]", ""));
                }
            }
        }
        return 0;
    }
    
    private static String extractName(String userJson) {
        String[] parts = userJson.split(",");
        for (String part : parts) {
            if (part.contains("name")) {
                String[] namePart = part.split(":");
                if (namePart.length > 1) {
                    return namePart[1].trim().replace("\"", "");
                }
            }
        }
        return "";
    }
    
    public static void main(String[] args) {
        // Create sample JSON file with users
        try (PrintWriter pw = new PrintWriter("users.json")) {
            pw.println("[");
            pw.println("  {\"name\": \"Alice\", \"age\": 23, \"email\": \"alice@example.com\"},");
            pw.println("  {\"name\": \"Bob\", \"age\": 30, \"email\": \"bob@example.com\"},");
            pw.println("  {\"name\": \"Charlie\", \"age\": 28, \"email\": \"charlie@example.com\"},");
            pw.println("  {\"name\": \"Diana\", \"age\": 22, \"email\": \"diana@example.com\"},");
            pw.println("  {\"name\": \"Eve\", \"age\": 35, \"email\": \"eve@example.com\"}");
            pw.println("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        filterUsersOlderThan25("users.json");
    }
}