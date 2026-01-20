package CSV_Handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortBySalary {

    public static void main(String[] args) {

        String filePath =
            "C:\\Users\\Anmol Tiwari\\git\\final repo\\BridgeLabz-Training\\IO-Programming-Java\\src\\gcr_codebase\\src\\CSV_Handling\\Employee.csv";

        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

          
            br.readLine();

      
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                records.add(data);
            }

            
            Collections.sort(records, (a, b) -> {
                double sal1 = Double.parseDouble(a[3]);
                double sal2 = Double.parseDouble(b[3]);
                return Double.compare(sal2, sal1); // descending
            });

   
            System.out.println("Top 5 Highest Paid Employees:");
            System.out.println("--------------------------------");

            for (int i = 0; i < 5 && i < records.size(); i++) {
                String[] emp = records.get(i);

                System.out.println(
                        "ID: " + emp[0] +
                        ", Name: " + emp[1] +
                        ", Department: " + emp[2] +
                        ", Salary: " + emp[3]
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
