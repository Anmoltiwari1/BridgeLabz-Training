import java.io.*;
import java.util.regex.Pattern;

public class CSVValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");
    
    public static void validateCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int rowNumber = 0;
            
            while ((line = br.readLine()) != null) {
                rowNumber++;
                if (rowNumber == 1) continue; // Skip header
                
                String[] columns = line.split(",");
                if (columns.length >= 3) {
                    String email = columns[1].trim();
                    String phone = columns[2].trim();
                    
                    boolean isValid = true;
                    StringBuilder errors = new StringBuilder();
                    
                    if (!EMAIL_PATTERN.matcher(email).matches()) {
                        errors.append("Invalid email format; ");
                        isValid = false;
                    }
                    
                    if (!PHONE_PATTERN.matcher(phone).matches()) {
                        errors.append("Invalid phone number (must be 10 digits); ");
                        isValid = false;
                    }
                    
                    if (!isValid) {
                        System.out.println("Row " + rowNumber + " - " + errors.toString() + "Data: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Create sample CSV file for testing
        try (PrintWriter pw = new PrintWriter("test_data.csv")) {
            pw.println("Name,Email,Phone");
            pw.println("John,john@email.com,1234567890");
            pw.println("Jane,invalid-email,123456789");
            pw.println("Bob,bob@test.com,12345678901");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        validateCSV("test_data.csv");
    }
}