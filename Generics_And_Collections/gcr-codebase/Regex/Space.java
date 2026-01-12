import java.util.Scanner;

public class Space {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=sc.nextLine();

        String res="";

        res=str.replaceAll(" +", " ");

        System.out.println("Resulted string is :");
        System.out.println(res);
    }
}
