import java.io.*;
import java.util.*;

public class DuplicateDetector {
    public static void detectDuplicates(String filename) {
        Map<String, List<String>> idToRecords = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;
            
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 1) continue; // Skip header
                
                String[] data = line.split(",");
                if (data.length > 0) {
                    String id = data[0].trim();
                    
                    idToRecords.computeIfAbsent(id, k -> new ArrayList<>()).add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        
        System.out.println("=== Duplicate Records ===");
        boolean foundDuplicates = false;
        
        for (Map.Entry<String, List<String>> entry : idToRecords.entrySet()) {
            if (entry.getValue().size() > 1) {
                foundDuplicates = true;
                System.out.println("Duplicate ID: " + entry.getKey());
                for (String record : entry.getValue()) {
                    System.out.println("  " + record);
                }
                System.out.println();
            }
        }
        
        if (!foundDuplicates) {
            System.out.println("No duplicates found.");
        }
    }
    
    public static void main(String[] args) {
        // Create sample CSV with duplicates
        try (PrintWriter pw = new PrintWriter("data_with_duplicates.csv")) {
            pw.println("ID,Name,Email");
            pw.println("1,Alice,alice@email.com");
            pw.println("2,Bob,bob@email.com");
            pw.println("1,Alice Smith,alice.smith@email.com");
            pw.println("3,Charlie,charlie@email.com");
            pw.println("2,Robert,robert@email.com");
            pw.println("4,David,david@email.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        detectDuplicates("data_with_duplicates.csv");
    }
}