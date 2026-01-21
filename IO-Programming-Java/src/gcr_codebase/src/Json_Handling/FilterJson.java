package Json_Handling;

import java.io.File;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterJson {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode root = mapper.readTree(new File("students.json"));

            for (JsonNode node : root) {
                int age = node.get("age").asInt();

                if (age > 25) {
                    System.out.println(node);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
