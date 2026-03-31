import java.io.*;
import java.util.Base64;

public class CSVEncryption {
    private static final String SECRET_KEY = "MySecretKey123";
    
    // Simple XOR encryption
    private static String encrypt(String data) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            char key = SECRET_KEY.charAt(i % SECRET_KEY.length());
            encrypted.append((char) (c ^ key));
        }
        return Base64.getEncoder().encodeToString(encrypted.toString().getBytes());
    }
    
    private static String decrypt(String encryptedData) {
        try {
            byte[] decoded = Base64.getDecoder().decode(encryptedData);
            String data = new String(decoded);
            
            StringBuilder decrypted = new StringBuilder();
            for (int i = 0; i < data.length(); i++) {
                char c = data.charAt(i);
                char key = SECRET_KEY.charAt(i % SECRET_KEY.length());
                decrypted.append((char) (c ^ key));
            }
            return decrypted.toString();
        } catch (Exception e) {
            return encryptedData; // Return original if decryption fails
        }
    }
    
    public static void writeEncryptedCSV(String filename) {
        try (PrintWriter pw = new PrintWriter(filename)) {
            pw.println("ID,Name,Email,Salary");
            
            // Sample data with sensitive fields encrypted
            pw.println("1,John," + encrypt("john@company.com") + "," + encrypt("75000"));
            pw.println("2,Jane," + encrypt("jane@company.com") + "," + encrypt("80000"));
            pw.println("3,Bob," + encrypt("bob@company.com") + "," + encrypt("70000"));
            
            System.out.println("Encrypted CSV written to: " + filename);
            
        } catch (IOException e) {
            System.out.println("Error writing encrypted CSV: " + e.getMessage());
        }
    }
    
    public static void readDecryptedCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isHeader = true;
            
            System.out.println("\n=== Decrypted Data ===");
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    System.out.println(line);
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(",");
                if (data.length >= 4) {
                    String id = data[0];
                    String name = data[1];
                    String email = decrypt(data[2]);
                    String salary = decrypt(data[3]);
                    
                    System.out.println(id + "," + name + "," + email + "," + salary);
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error reading encrypted CSV: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String filename = "encrypted_data.csv";
        
        // Write encrypted CSV
        writeEncryptedCSV(filename);
        
        // Show raw encrypted content
        System.out.println("\n=== Raw Encrypted Content ===");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Read and decrypt CSV
        readDecryptedCSV(filename);
    }
}