import java.util.Scanner;

public class RemAndQuest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the 2 numbers to be used");
        int a=sc.nextInt();
        int b=sc.nextInt();

        double[] res=new double[2];

        res=findRemainderAndQuotient(a, b);

        System.out.println("The the quotient is = "+res[0] +" and the remainder is = "+res[1]);
        sc.close();
    }
    public static double[] findRemainderAndQuotient(int a,int b){
        int q=a/b;
        int r=a%b;

        double[] res=new double[]{q,r};

        return res;
    }

}
