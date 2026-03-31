package Json_Handling;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonMerger {
	public static void main(String[] args) {
		
		ObjectMapper mapper=new ObjectMapper();
		ObjectNode merged=mapper.createObjectNode();
		
		try {
			JsonNode json1=mapper.readTree(new File("C:\\Users\\Anmol Tiwari\\git\\final repo\\BridgeLabz-Training\\IO-Programming-Java\\src\\gcr_codebase\\src\\Json_Handling\\File1.json"));
			JsonNode json2=mapper.readTree(new File("C:\\Users\\Anmol Tiwari\\git\\final repo\\BridgeLabz-Training\\IO-Programming-Java\\src\\gcr_codebase\\src\\Json_Handling\\File2.json"));
			
			merged.setAll((ObjectNode) json1);
			mapper.writeValue(new File("C:\\Users\\Anmol Tiwari\\git\\final repo\\BridgeLabz-Training\\IO-Programming-Java\\src\\gcr_codebase\\src\\Json_Handling\\merged.json"), merged);
			System.out.println("Merged Json : " +merged.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
