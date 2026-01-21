package Json_Handling;

import java.io.File;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSON {
	public static void main(String[] args) {
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			JsonNode root=mapper.readTree(new File("C:\\Users\\Anmol Tiwari\\git\\final repo\\BridgeLabz-Training\\IO-Programming-Java\\src\\gcr_codebase\\src\\Json_Handling\\Data.json"));
			
			
			if(!root.has("name") ||  !root.get("name").isTextual()) {
				throw new RuntimeErrorException(null, "Ivalid or mssing name");
			}
			
			if(!root.has("age") || !root.get("age").isInt()) {
				throw new RuntimeException("Invalid or missing age");
			}
			
			if(!root.has("email") || !root.get("email").isTextual()) {
				throw new RuntimeException("Invalid or missing email");
			}
			
			System.out.println("JSON Structure is Valid");
			
		} catch (Exception e) {
			System.out.println("Error is :"+e.getMessage());
		}
	}
}
