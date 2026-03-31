import java.util.Scanner;
import java.util.regex.*;

public class EmailExtractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Extracted emails:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}