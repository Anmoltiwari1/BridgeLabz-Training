package CSV_Handling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class UpdateSalary {

    public static void main(String[] args) {

        String inputPath =
            "C:\\Users\\Anmol Tiwari\\git\\final repo\\BridgeLabz-Training\\IO-Programming-Java\\src\\gcr_codebase\\src\\CSV_Handling\\Employee.csv";

        String outputPath =
            "C:\\Users\\Anmol Tiwari\\git\\final repo\\BridgeLabz-Training\\IO-Programming-Java\\src\\gcr_codebase\\src\\CSV_Handling\\Employee_Updated.csv";

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputPath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))
        ) {

            String line;

            
            line = br.readLine();
            bw.write(line);
            bw.newLine();

            
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String department = data[2];
                double salary = Double.parseDouble(data[3]);

               
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary * 1.10;
                }

               
                String updatedLine =
                        data[0] + "," +
                        data[1] + "," +
                        data[2] + "," +
                        (int) salary;

                
                bw.write(updatedLine);
                bw.newLine();
            }

            System.out.println("Updated CSV file created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
