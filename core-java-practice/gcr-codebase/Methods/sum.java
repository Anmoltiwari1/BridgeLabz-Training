import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=sc.nextInt();

        System.out.println("The sum is = "+Sum(n));
        sc.close();
    }

    public static int Sum(int n){
        int res=0;
        for(int i=1;i<=n;i++){
            res+=i;
        }

        return res;
    }
}
