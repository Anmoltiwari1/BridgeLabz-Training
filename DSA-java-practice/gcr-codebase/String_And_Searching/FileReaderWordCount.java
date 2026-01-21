import java.io.*;
import java.util.Scanner;

public class FileReaderWordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String fileName = sc.nextLine();
        System.out.print("Enter word to search: ");
        String targetWord = sc.nextLine();
        
        int count = countWordInFile(fileName, targetWord);
        System.out.println("Word '" + targetWord + "' appears " + count + " times");
        sc.close();
    }
    
    public static int countWordInFile(String fileName, String targetWord) {
        int count = 0;
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return count;
    }
}