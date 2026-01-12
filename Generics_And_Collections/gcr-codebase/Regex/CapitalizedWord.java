import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedWord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=sc.nextLine();

        capt(str);

    }

    public static void capt(String str){
        String regex="\\b[A-Z][A-Za-z]*\\b";

        Pattern pattern= Pattern.compile(regex);
        Matcher matcher=pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        
    }
}
