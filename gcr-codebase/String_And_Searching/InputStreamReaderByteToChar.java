import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderByteToChar {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}