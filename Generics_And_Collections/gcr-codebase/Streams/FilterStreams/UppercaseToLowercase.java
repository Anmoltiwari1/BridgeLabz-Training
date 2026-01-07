import java.io.*;

public class UppercaseToLowercase {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
            
            System.out.println("File converted to lowercase");
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}