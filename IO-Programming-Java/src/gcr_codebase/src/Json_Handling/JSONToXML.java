import java.io.*;

public class JSONToXML {
    public static void convertJSONToXML(String jsonFile, String xmlFile) {
        try {
            String jsonContent = readFile(jsonFile);
            String xmlContent = convertToXML(jsonContent);
            
            try (PrintWriter pw = new PrintWriter(xmlFile)) {
                pw.println(xmlContent);
                System.out.println("JSON converted to XML: " + xmlFile);
            }
            
        } catch (IOException e) {
            System.out.println("Error converting JSON to XML: " + e.getMessage());
        }
    }
    
    private static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim();
    }
    
    private static String convertToXML(String json) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xml.append("<root>\n");
        
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
                    
                    xml.append("  <").append(key).append(">")
                       .append(value)
                       .append("</").append(key).append(">\n");
                }
            }
        }
        
        xml.append("</root>");
        return xml.toString();
    }
    
    private static String[] splitByComma(String str) {
        String[] parts = str.split(",");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        return parts;
    }
    
    public static void main(String[] args) {
        // Create sample JSON file
        try (PrintWriter pw = new PrintWriter("person.json")) {
            pw.println("{");
            pw.println("  \"name\": \"Alice Smith\",");
            pw.println("  \"age\": \"28\",");
            pw.println("  \"email\": \"alice@example.com\",");
            pw.println("  \"city\": \"New York\"");
            pw.println("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        convertJSONToXML("person.json", "person.xml");
        
        // Display XML result
        try (BufferedReader br = new BufferedReader(new FileReader("person.xml"))) {
            System.out.println("\n=== Generated XML ===");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}