import java.util.Scanner;

public class Chocolates {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of Chocolates");
        int N=sc.nextInt();
        System.out.println("Enter the number of Children");
        int M=sc.nextInt();

        double[] res=new double[2];

        res=findRemainderAndQuotient(N, M);

        System.out.println("No of chocolates each student will get "+res[0]+" no of left out chocolates are "+res[1]);

        sc.close();
    }

    public static double[] findRemainderAndQuotient(int a,int b){
        int q=a/b;
        int r=a%b;

        double[] res=new double[]{q,r};

        return res;
    }
}
