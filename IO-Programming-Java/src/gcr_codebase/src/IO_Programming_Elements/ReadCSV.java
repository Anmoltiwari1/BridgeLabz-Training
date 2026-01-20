import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

    public static void main(String[] args) {

        String filePath = "students.csv"; // or full path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // 1️⃣ Read and skip header
            br.readLine();

            // 2️⃣ Read remaining lines
            while ((line = br.readLine()) != null) {

                // 3️⃣ Split line by comma
                String[] data = line.split(",");

                // 4️⃣ Extract values using index
                String id = data[0];
                String name = data[1];
                String age = data[2];
                String marks = data[3];

                // 5️⃣ Print in structured format
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
