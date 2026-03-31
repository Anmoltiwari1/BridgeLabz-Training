import java.io.*;
import java.util.*;

public class JSONReader {
    public static void readJSON(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }
            
            String json = jsonContent.toString().trim();
            parseAndPrint(json, "");
            
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }
    
    private static void parseAndPrint(String json, String prefix) {
        json = json.trim();
        
        if (json.startsWith("{") && json.endsWith("}")) {
            json = json.substring(1, json.length() - 1);
            String[] pairs = splitByComma(json);
            
            for (String pair : pairs) {
                int colonIndex = pair.indexOf(":");
                if (colonIndex > 0) {
                    String key = pair.substring(0, colonIndex).trim().replace("\"", "");
                    String value = pair.substring(colonIndex + 1).trim();
                    
                    if (value.startsWith("\"") && value.endsWith("\"")) {
                        value = value.substring(1, value.length() - 1);
                    }
                    
                    System.out.println(prefix + "Key: " + key + " | Value: " + value);
                }
            }
        }
    }
    
    private static String[] splitByComma(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        int braceCount = 0;
        
        for (char c : str.toCharArray()) {
            if (c == '"') inQuotes = !inQuotes;
            if (!inQuotes) {
                if (c == '{') braceCount++;
                if (c == '}') braceCount--;
            }
            
            if (c == ',' && !inQuotes && braceCount == 0) {
                result.add(current.toString().trim());
                current = new StringBuilder();
            } else {
                current.append(c);
            }
        }
        
        if (current.length() > 0) {
            result.add(current.toString().trim());
        }
        
        return result.toArray(new String[0]);
    }
    
    public static void main(String[] args) {
        // Create sample JSON file
        try (PrintWriter pw = new PrintWriter("sample.json")) {
            pw.println("{");
            pw.println("  \"name\": \"John Doe\",");
            pw.println("  \"age\": 30,");
            pw.println("  \"email\": \"john@example.com\",");
            pw.println("  \"city\": \"New York\"");
            pw.println("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        readJSON("sample.json");
    }
}