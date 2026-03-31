import java.util.Scanner;

public class LinearSearchSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        String[] sentences = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter sentence " + (i + 1) + ": ");
            sentences[i] = sc.nextLine();
        }
        
        System.out.print("Enter word to search: ");
        String word = sc.nextLine();
        
        String result = findSentenceWithWord(sentences, word);
        System.out.println("Result: " + result);
        sc.close();
    }
    
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }
}