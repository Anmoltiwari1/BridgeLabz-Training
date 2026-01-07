import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filename = "large_log.txt";
        int errorCount = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;
            
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Line " + lineNumber + ": " + line);
                    errorCount++;
                }
            }
            
            System.out.println("Total error lines: " + errorCount);
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}