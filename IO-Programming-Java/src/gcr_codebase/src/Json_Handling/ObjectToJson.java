package Json_Handling;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


public class ObjectToJson {
	public static void main(String[] args) {
		
		ObjectMapper mapper=new ObjectMapper();
		
		Student s1=new Student("Anmol",23,Arrays.asList("Java","AWS"));
		Student s2=new Student("Raj",24,Arrays.asList("Python","ML"));
		
		List<Student> students=Arrays.asList(s1,s2);
		
		try {
			String jsonArray = mapper.writeValueAsString(students);

			System.out.println(jsonArray);
		} catch (Exception e) {
			System.out.println("Error :"+e.getMessage());
		}
		

		
	}
}
