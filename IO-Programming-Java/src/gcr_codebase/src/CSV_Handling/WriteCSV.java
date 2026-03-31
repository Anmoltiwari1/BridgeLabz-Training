package CSV_Handling;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteCSV {
	public static void main(String[] args) {
		
		String filepath="C:\\Users\\Anmol Tiwari\\eclipse-workspace\\gcr_codebase\\src\\csv_handling\\employee.csv";
		
		try(BufferedWriter bw =new BufferedWriter(new FileWriter(filepath))) {
			
			bw.write("ID,Name,Department,Salary");
			bw.newLine();
			
			bw.write("1,Anmol,IT,300000");
			bw.newLine();
			bw.write("2,Pranav,IT,500000");
			bw.newLine();
			bw.write("3,Amit,IT,340000");
			bw.newLine();
			bw.write("4,Parv,IT,330000");
			bw.newLine();
			bw.write("5,Praveen,IT,310000");
			
			bw.close();
			
			System.out.println("File created");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
