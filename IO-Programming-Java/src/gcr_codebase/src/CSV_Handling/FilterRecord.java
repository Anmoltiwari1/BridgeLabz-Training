package CSV_Handling;

import java.io.BufferedReader;
import java.io.FileReader;

public class FilterRecord {
	public static void main(String[] args) {
		
		String line;
		
		String Filepath="C:\\Users\\Anmol Tiwari\\git\\final repo\\BridgeLabz-Training\\IO-Programming-Java\\src\\gcr_codebase\\src\\CSV_Handling\\Data.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(Filepath))) {
			
			br.readLine();
			
			while((line=br.readLine())!=null) {
				String[]  data=line.split(",");
				
				int marks=Integer.parseInt(data[3]);
				
				if(marks>80) {
					System.out.println("ID is:"+data[0] +"  "+"Name is:"+data[1]+"  "+"Age is:"+data[2]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
