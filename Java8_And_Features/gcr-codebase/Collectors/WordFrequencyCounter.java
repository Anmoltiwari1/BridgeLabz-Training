import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String paragraph = "Java is great. Java is powerful. Programming in Java is fun. Java developers love Java.";
        
        Map<String, Long> wordFrequency = Arrays.stream(paragraph.toLowerCase().split("\\W+"))
            .filter(word -> !word.isEmpty())
            .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            ));
        
        System.out.println("Word frequency analysis:");
        wordFrequency.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(entry -> 
                System.out.println(entry.getKey() + ": " + entry.getValue()));
        
        // Alternative using toMap
        Map<String, Integer> wordCount = Arrays.stream(paragraph.toLowerCase().split("\\W+"))
            .filter(word -> !word.isEmpty())
            .collect(Collectors.toMap(
                Function.identity(),
                word -> 1,
                Integer::sum
            ));
        
        System.out.println("\nUsing toMap approach:");
        wordCount.forEach((word, count) -> 
            System.out.println(word + ": " + count));
    }
}