import java.util.Scanner;

public class SumOfN {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number n");
        int n=sc.nextInt();
        int s=0,c=0;

        s=sum(n);
        c=check(n);

        if(s==c){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

        sc.close();
    }

    public static int sum(int n){

        if(n==0)
            return 0;

       return n+sum(n-1);
    }

    public static int check(int n){
        return n*(n+1)/2;
    }
}
