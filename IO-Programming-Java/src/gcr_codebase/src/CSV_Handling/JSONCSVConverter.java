import java.io.*;
import java.util.*;

public class JSONCSVConverter {
    
    public static void jsonToCSV(String jsonFile, String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile));
             PrintWriter pw = new PrintWriter(csvFile)) {
            
            // Simple JSON parsing (assuming array of objects)
            String line;
            StringBuilder jsonContent = new StringBuilder();
            
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }
            
            // Parse simple JSON format
            String json = jsonContent.toString().trim();
            if (json.startsWith("[") && json.endsWith("]")) {
                json = json.substring(1, json.length() - 1);
                
                pw.println("name,age,email");
                
                String[] objects = json.split("\\},\\s*\\{");
                for (String obj : objects) {
                    obj = obj.replace("{", "").replace("}", "");
                    String[] fields = obj.split(",");
                    
                    String name = "", age = "", email = "";
                    for (String field : fields) {
                        String[] keyValue = field.split(":");
                        if (keyValue.length == 2) {
                            String key = keyValue[0].trim().replace("\"", "");
                            String value = keyValue[1].trim().replace("\"", "");
                            
                            switch (key) {
                                case "name": name = value; break;
                                case "age": age = value; break;
                                case "email": email = value; break;
                            }
                        }
                    }
                    pw.println(name + "," + age + "," + email);
                }
            }
            
            System.out.println("JSON converted to CSV: " + csvFile);
            
        } catch (IOException e) {
            System.out.println("Error converting JSON to CSV: " + e.getMessage());
        }
    }
    
    public static void csvToJSON(String csvFile, String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             PrintWriter pw = new PrintWriter(jsonFile)) {
            
            String line;
            boolean isHeader = true;
            String[] headers = null;
            
            pw.println("[");
            boolean first = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    headers = line.split(",");
                    isHeader = false;
                    continue;
                }
                
                if (!first) {
                    pw.println(",");
                }
                first = false;
                
                String[] values = line.split(",");
                pw.print("  {");
                
                for (int i = 0; i < headers.length && i < values.length; i++) {
                    if (i > 0) pw.print(", ");
                    pw.print("\"" + headers[i].trim() + "\": \"" + values[i].trim() + "\"");
                }
                
                pw.print("}");
            }
            
            pw.println("\n]");
            System.out.println("CSV converted to JSON: " + jsonFile);
            
        } catch (IOException e) {
            System.out.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Create sample JSON file
        try (PrintWriter pw = new PrintWriter("students.json")) {
            pw.println("[");
            pw.println("  {\"name\": \"Alice\", \"age\": \"20\", \"email\": \"alice@email.com\"},");
            pw.println("  {\"name\": \"Bob\", \"age\": \"22\", \"email\": \"bob@email.com\"},");
            pw.println("  {\"name\": \"Charlie\", \"age\": \"21\", \"email\": \"charlie@email.com\"}");
            pw.println("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Convert JSON to CSV
        jsonToCSV("students.json", "converted_students.csv");
        
        // Convert CSV back to JSON
        csvToJSON("converted_students.csv", "converted_back.json");
    }
}