import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        Map<String, Integer> frequency = countWordFrequency(text);
        System.out.println("Input: \"" + text + "\"");
        System.out.println("Output: " + frequency);
    }
    
    static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> frequency = new HashMap<>();
        
        // Remove punctuation and convert to lowercase
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }
        
        return frequency;
    }
}