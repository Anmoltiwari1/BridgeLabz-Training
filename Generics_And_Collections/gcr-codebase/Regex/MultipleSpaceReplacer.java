import java.util.Scanner;

public class MultipleSpaceReplacer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        
        String regex = "\\s+";
        String result = text.replaceAll(regex, " ");
        
        System.out.println("Result:");
        System.out.println("\"" + result + "\"");
    }
}