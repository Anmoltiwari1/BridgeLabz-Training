import java.util.Scanner;

public class Divisible {
    public static void main(String[] args) {
        Boolean check=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number to be checked");
        int n=sc.nextInt();

        if(n%5==0)
        {
            check=true;
        }

        System.out.println("Is the number "+n+"divisible by 5? "+check);
    }
}
