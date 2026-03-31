import java.util.Scanner;

public class StringBuild {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String to be reversed");
        String str=sc.nextLine();

        StringBuilder sb=new StringBuilder(str);
        sb.reverse();

        System.out.println("The reversed String is: "+sb);
        
    }
}
