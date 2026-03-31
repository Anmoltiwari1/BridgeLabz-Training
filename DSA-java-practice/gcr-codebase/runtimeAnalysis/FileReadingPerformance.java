import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReadingPerformance {
    public static void main(String[] args) {
        String[] fileSizes = {"1MB", "10MB", "50MB"};
        int[] lineCounts = {10000, 100000, 500000};
        
        for (int i = 0; i < fileSizes.length; i++) {
            String fileName = "test_" + fileSizes[i] + ".txt";
            createTestFile(fileName, lineCounts[i]);
            
            System.out.println("\n=== File Size: " + fileSizes[i] + " ===");
            
            // FileReader test
            long startTime = System.currentTimeMillis();
            readWithFileReader(fileName);
            long frTime = System.currentTimeMillis() - startTime;
            
            // InputStreamReader test
            startTime = System.currentTimeMillis();
            readWithInputStreamReader(fileName);
            long isrTime = System.currentTimeMillis() - startTime;
            
            System.out.println("FileReader: " + frTime + " ms");
            System.out.println("InputStreamReader: " + isrTime + " ms");
            System.out.println("InputStreamReader is " + (frTime / (double)isrTime) + "x faster");
            
            // Clean up
            new File(fileName).delete();
        }
    }
    
    private static void createTestFile(String fileName, int lineCount) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (int i = 0; i < lineCount; i++) {
                fw.write("This is test line " + i + " with some content for performance testing.\n");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
    
    private static void readWithFileReader(String fileName) {
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            
            while (br.readLine() != null) {
                // Just read, don't process
            }
        } catch (IOException e) {
            System.out.println("Error reading with FileReader: " + e.getMessage());
        }
    }
    
    private static void readWithInputStreamReader(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {
            
            while (br.readLine() != null) {
                // Just read, don't process
            }
        } catch (IOException e) {
            System.out.println("Error reading with InputStreamReader: " + e.getMessage());
        }
    }
}