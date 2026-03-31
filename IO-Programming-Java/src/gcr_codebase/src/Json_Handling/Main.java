package Json_Handling;

import java.util.Arrays;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {
	public static void main(String[] args) {
		Student s=new Student("Anmol",23,Arrays.asList("AWS","Java"));
		
		 Car car=new Car(2023,"Model S","Tesla");
		try {
			ObjectMapper mapper=new ObjectMapper();
			String data=mapper.writeValueAsString(s);
			String json=mapper.writeValueAsString(car);
			
			System.out.println("Data is :"+data);
			
			System.out.println("Json is :"+json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
