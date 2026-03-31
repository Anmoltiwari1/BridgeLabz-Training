import java.util.Scanner;
import java.util.regex.*;

public class DateExtractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Extracted dates:");
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }
}