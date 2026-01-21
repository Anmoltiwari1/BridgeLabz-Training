import java.io.*;

public class LargeCSVReader {
    private static final int CHUNK_SIZE = 100;
    
    public static void readLargeCSVInChunks(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int totalRecords = 0;
            int chunkCount = 0;
            int recordsInChunk = 0;
            
            while ((line = br.readLine()) != null) {
                if (totalRecords == 0) {
                    totalRecords++; // Skip header
                    continue;
                }
                
                recordsInChunk++;
                totalRecords++;
                
                // Process the line here (for demo, just count)
                
                if (recordsInChunk == CHUNK_SIZE) {
                    chunkCount++;
                    System.out.println("Processed chunk " + chunkCount + " - Records: " + recordsInChunk);
                    recordsInChunk = 0;
                    
                    // Simulate processing time
                    Thread.sleep(100);
                }
            }
            
            // Process remaining records
            if (recordsInChunk > 0) {
                chunkCount++;
                System.out.println("Processed final chunk " + chunkCount + " - Records: " + recordsInChunk);
            }
            
            System.out.println("Total records processed: " + (totalRecords - 1));
            System.out.println("Total chunks: " + chunkCount);
            
        } catch (IOException | InterruptedException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void createLargeCSVFile(String filename, int recordCount) {
        try (PrintWriter pw = new PrintWriter(filename)) {
            pw.println("ID,Name,Email,Phone");
            
            for (int i = 1; i <= recordCount; i++) {
                pw.println(i + ",User" + i + ",user" + i + "@email.com,123456789" + (i % 10));
            }
            
            System.out.println("Created " + filename + " with " + recordCount + " records");
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String filename = "large_data.csv";
        
        // Create a sample large CSV file
        createLargeCSVFile(filename, 500);
        
        // Read it in chunks
        readLargeCSVInChunks(filename);
    }
}