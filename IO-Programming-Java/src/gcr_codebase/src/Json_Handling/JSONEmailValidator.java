import java.io.*;
import java.util.regex.Pattern;

public class JSONEmailValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    
    public static void validateEmailsInJSON(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }
            
            String json = jsonContent.toString();
            validateEmails(json);
            
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }
    
    private static void validateEmails(String json) {
        System.out.println("=== Email Validation Results ===");
        
        // Extract email fields from JSON
        String[] lines = json.split("\n");
        for (String line : lines) {
            if (line.contains("email")) {
                String email = extractEmailFromLine(line);
                if (!email.isEmpty()) {
                    boolean isValid = EMAIL_PATTERN.matcher(email).matches();
                    System.out.println("Email: " + email + " - " + (isValid ? "✅ Valid" : "❌ Invalid"));
                }
            }
        }
    }
    
    private static String extractEmailFromLine(String line) {
        int startIndex = line.indexOf("\"email\":");
        if (startIndex != -1) {
            int valueStart = line.indexOf("\"", startIndex + 8);
            if (valueStart != -1) {
                int valueEnd = line.indexOf("\"", valueStart + 1);
                if (valueEnd != -1) {
                    return line.substring(valueStart + 1, valueEnd);
                }
            }
        }
        return "";
    }
    
    public static void main(String[] args) {
        // Create sample JSON with valid and invalid emails
        try (PrintWriter pw = new PrintWriter("email_data.json")) {
            pw.println("{");
            pw.println("  \"users\": [");
            pw.println("    {\"name\": \"Alice\", \"email\": \"alice@example.com\"},");
            pw.println("    {\"name\": \"Bob\", \"email\": \"invalid-email\"},");
            pw.println("    {\"name\": \"Charlie\", \"email\": \"charlie@test.org\"},");
            pw.println("    {\"name\": \"Diana\", \"email\": \"diana.email.com\"},");
            pw.println("    {\"name\": \"Eve\", \"email\": \"eve@company.co.uk\"}");
            pw.println("  ]");
            pw.println("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        validateEmailsInJSON("email_data.json");
    }
}