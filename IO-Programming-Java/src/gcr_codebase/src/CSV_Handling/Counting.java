package CSV_Handling;

import java.io.BufferedReader;
import java.io.FileReader;

public class Counting {
	public static void main(String[] args) {
		
		String filePath="C:\\Users\\Anmol Tiwari\\git\\final repo\\BridgeLabz-Training\\IO-Programming-Java\\src\\gcr_codebase\\src\\IO_Programming_Elements\\Data.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			
			String line;
			
			br.readLine();
			
			int counter=0;
			
			while((line = br.readLine()) != null) {
				counter++;
			}
			
			System.out.println("No of records is : "+counter);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
