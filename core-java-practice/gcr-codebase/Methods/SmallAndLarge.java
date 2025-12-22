import java.util.Scanner;

public class SmallAndLarge {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the 3 numbers");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();

        int[] res=new int[2];

        res=findSmallestAndLargest(a, b, c);

        System.out.println("Largest is = "+res[0]+" Smallest is = "+res[1]);
        sc.close();
    }

    public static int[] findSmallestAndLargest(int a,int b,int c){
        int max=0,min=0;

        max=Math.max(Math.max(a,b),c);

        min=Math.min(Math.min(a,b),c);

        int[] res=new int[]{max,min};

        return res;
    }
}
