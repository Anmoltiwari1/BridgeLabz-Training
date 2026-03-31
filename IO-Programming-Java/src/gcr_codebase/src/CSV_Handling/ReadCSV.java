package CSV_Handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

    public static void main(String[] args) {

        String filePath = "students.csv"; 

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            
            br.readLine();

            
            while ((line = br.readLine()) != null) {

                
                String[] data = line.split(",");

                
                String id = data[0];
                String name = data[1];
                String age = data[2];
                String marks = data[3];

                
                System.out.println(
                        "ID: " + id +
                        ", Name: " + name +
                        ", Age: " + age +
                        ", Marks: " + marks
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
