import java.io.*;

public class InputStreamReaderUserInput {
    public static void main(String[] args) {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter("output.txt")) {
            
            System.out.println("Enter text (type 'exit' to stop):");
            String input;
            while (!(input = br.readLine()).equals("exit")) {
                fw.write(input + "\n");
            }
            System.out.println("Input saved to output.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}