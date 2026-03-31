import java.io.*;

public class CSVToJSON {
    public static void convertCSVToJSON(String csvFile, String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             PrintWriter pw = new PrintWriter(jsonFile)) {
            
            String line;
            String[] headers = null;
            boolean isFirstLine = true;
            
            pw.println("[");
            boolean firstRecord = true;
            
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    headers = line.split(",");
                    isFirstLine = false;
                    continue;
                }
                
                if (!firstRecord) {
                    pw.println(",");
                }
                firstRecord = false;
                
                String[] values = line.split(",");
                pw.print("  {");
                
                for (int i = 0; i < headers.length && i < values.length; i++) {
                    if (i > 0) pw.print(", ");
                    pw.print("\"" + headers[i].trim() + "\": \"" + values[i].trim() + "\"");
                }
                
                pw.print("}");
            }
            
            pw.println("\n]");
            System.out.println("CSV converted to JSON: " + jsonFile);
            
        } catch (IOException e) {
            System.out.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Create sample CSV file
        try (PrintWriter pw = new PrintWriter("employees.csv")) {
            pw.println("ID,Name,Department,Salary");
            pw.println("1,John Doe,Engineering,75000");
            pw.println("2,Jane Smith,Marketing,65000");
            pw.println("3,Bob Johnson,Engineering,80000");
            pw.println("4,Alice Brown,HR,60000");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        convertCSVToJSON("employees.csv", "employees.json");
        
        // Display JSON result
        try (BufferedReader br = new BufferedReader(new FileReader("employees.json"))) {
            System.out.println("\n=== Generated JSON ===");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}