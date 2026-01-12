import java.util.Scanner;
import java.util.regex.*;

public class URLExtractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        
        String regex = "https?://[\\w.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Extracted URLs:");
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }
}