import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String filename = "sample_text.txt";
        Map<String, Integer> wordCount = new HashMap<>();
        int totalWords = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                        totalWords++;
                    }
                }
            }
            
            System.out.println("Total words: " + totalWords);
            System.out.println("Unique words: " + wordCount.size());
            
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
            sortedWords.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
            
            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
                Map.Entry<String, Integer> entry = sortedWords.get(i);
                System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue() + " times");
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}