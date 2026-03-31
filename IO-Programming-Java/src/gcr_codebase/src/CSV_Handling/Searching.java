package CSV_Handling;

import java.io.BufferedReader;
import java.io.FileReader;

public class Searching {
	public static void main(String[] args) {
		
		String filePath="C:\\Users\\Anmol Tiwari\\git\\final repo\\BridgeLabz-Training\\IO-Programming-Java\\src\\gcr_codebase\\src\\CSV_Handling\\Employee.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			
			String search="Anmol";
			String line; 
			boolean flag=false;
			
			br.readLine();
			
			while((line=br.readLine())!=null) {
				String[] data=line.split(",");
				
				String name=data[1];
				
				if(name.equalsIgnoreCase(search)) {
					System.out.print("Department :"+data[2] + " Salary :"+data[3]);
					flag=true;
					break;
				}
			}
			if(flag==false) {
				
				System.out.println("Record not found");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
