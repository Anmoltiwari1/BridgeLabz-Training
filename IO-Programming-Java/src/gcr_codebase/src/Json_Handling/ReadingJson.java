package Json_Handling;

import java.io.File;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadingJson {
	public static void main(String[] args) {
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			JsonNode root=mapper.readTree(new File("C:\\Users\\Anmol Tiwari\\git\\final repo\\BridgeLabz-Training\\IO-Programming-Java\\src\\gcr_codebase\\src\\Json_Handling\\Data.json"));
			
			for(JsonNode node:root) {
				String name=node.get("name").asText();
				String email=node.get("email").asText();
				
				System.out.println(name +" : "+email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
