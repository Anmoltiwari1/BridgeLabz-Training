import java.util.Scanner;

public class BadWord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=sc.nextLine();

         String regex = "(?i)damn|stupid";

         String replacement = "****";

         String res="";

         res=str.replaceAll(regex, replacement);

         System.out.println("Resulted string is :");
         System.out.println(res);
    }
}
