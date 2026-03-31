import java.io.*;
import java.util.*;

public class CSVMerger {
    public static void mergeCSVFiles(String file1, String file2, String outputFile) {
        Map<String, String> file1Data = new HashMap<>();
        Map<String, String> file2Data = new HashMap<>();
        
        // Read first CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String id = data[0].trim();
                    String record = data[1].trim() + "," + data[2].trim();
                    file1Data.put(id, record);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file1: " + e.getMessage());
            return;
        }
        
        // Read second CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String id = data[0].trim();
                    String record = data[1].trim() + "," + data[2].trim();
                    file2Data.put(id, record);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file2: " + e.getMessage());
            return;
        }
        
        // Merge and write to output file
        try (PrintWriter pw = new PrintWriter(outputFile)) {
            pw.println("ID,Name,Age,Marks,Grade");
            
            for (String id : file1Data.keySet()) {
                if (file2Data.containsKey(id)) {
                    pw.println(id + "," + file1Data.get(id) + "," + file2Data.get(id));
                }
            }
            
            System.out.println("Files merged successfully into " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing output file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Create sample CSV files
        try (PrintWriter pw1 = new PrintWriter("students1.csv")) {
            pw1.println("ID,Name,Age");
            pw1.println("1,Alice,20");
            pw1.println("2,Bob,22");
            pw1.println("3,Charlie,21");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (PrintWriter pw2 = new PrintWriter("students2.csv")) {
            pw2.println("ID,Marks,Grade");
            pw2.println("1,85,A");
            pw2.println("2,78,B");
            pw2.println("3,92,A");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        mergeCSVFiles("students1.csv", "students2.csv", "merged_students.csv");
    }
}