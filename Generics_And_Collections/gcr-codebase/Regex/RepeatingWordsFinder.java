import java.util.Scanner;
import java.util.regex.*;
import java.util.*;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sentence:");
        String sentence = sc.nextLine();
        
        String regex = "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sentence);
        
        Set<String> repeatedWords = new HashSet<>();
        
        while (matcher.find()) {
            repeatedWords.add(matcher.group(1).toLowerCase());
        }
        
        System.out.println("Repeating words:");
        for (String word : repeatedWords) {
            System.out.print(word + ", ");
        }
    }
}