import java.util.Scanner;

public class TrianglePerimeter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the 3 sides of triangle");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();

        double r=round(a, b, c);

        System.out.println("No of rounds in athelet have to run = "+ r);

        sc.close();

    }

    public static double round(int a,int b,int c){
        int perimeter=(a+b+c);

        double rounds=5000/perimeter;

        return rounds;
    }
}
