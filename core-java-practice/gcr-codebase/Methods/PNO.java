import java.util.Scanner;

public class PNO {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number to be checked");
        int n=sc.nextInt();

        System.out.println(check(n));
        sc.close();
    }

    public static int check(int n){
        if(n==0)
            return 0;
        else if(n>0)
            return 1;
        else
            return -1;
    }
}
