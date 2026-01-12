import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDates {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=sc.nextLine();

        extract(str);
    }

    public static void extract(String str){
        String regex="[0-9]{2}/[0-9]{2}/[0-9]{4}";

        Pattern pattern= Pattern.compile(regex);
        Matcher matcher=pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
