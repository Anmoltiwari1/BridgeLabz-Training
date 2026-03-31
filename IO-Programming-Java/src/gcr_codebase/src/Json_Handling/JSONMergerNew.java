import java.io.*;
import java.util.*;

public class JSONMergerNew {
    public static void mergeJSONFiles(String file1, String file2, String outputFile) {
        try {
            String json1 = readJSONFile(file1);
            String json2 = readJSONFile(file2);
            
            String mergedJSON = mergeJSONObjects(json1, json2);
            
            try (PrintWriter pw = new PrintWriter(outputFile)) {
                pw.println(mergedJSON);
                System.out.println("JSON files merged successfully into: " + outputFile);
            }
            
        } catch (IOException e) {
            System.out.println("Error merging JSON files: " + e.getMessage());
        }
    }
    
    private static String readJSONFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim();
    }
    
    private static String mergeJSONObjects(String json1, String json2) {
        // Remove outer braces
        json1 = json1.trim();
        json2 = json2.trim();
        
        if (json1.startsWith("{") && json1.endsWith("}")) {
            json1 = json1.substring(1, json1.length() - 1);
        }
        
        if (json2.startsWith("{") && json2.endsWith("}")) {
            json2 = json2.substring(1, json2.length() - 1);
        }
        
        StringBuilder merged = new StringBuilder("{\n");
        merged.append(json1.trim());
        
        if (!json1.trim().isEmpty() && !json2.trim().isEmpty()) {
            merged.append(",\n");
        }
        
        merged.append(json2.trim());
        merged.append("\n}");
        
        return merged.toString();
    }
    
    public static void main(String[] args) {
        // Create first JSON file
        try (PrintWriter pw = new PrintWriter("user_basic.json")) {
            pw.println("{");
            pw.println("  \"name\": \"John Doe\",");
            pw.println("  \"age\": 30,");
            pw.println("  \"email\": \"john@example.com\"");
            pw.println("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Create second JSON file
        try (PrintWriter pw = new PrintWriter("user_details.json")) {
            pw.println("{");
            pw.println("  \"address\": \"123 Main St\",");
            pw.println("  \"phone\": \"555-1234\",");
            pw.println("  \"department\": \"Engineering\"");
            pw.println("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        mergeJSONFiles("user_basic.json", "user_details.json", "merged_user.json");
        
        // Display merged result
        try (BufferedReader br = new BufferedReader(new FileReader("merged_user.json"))) {
            System.out.println("\n=== Merged JSON ===");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}