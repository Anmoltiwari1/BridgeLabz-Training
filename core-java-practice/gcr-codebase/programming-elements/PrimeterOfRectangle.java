import java.util.Scanner;

public class PrimeterOfRectangle{
    public static void main(String[] args) {
        double per=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of length and breadth");
        double l=sc.nextDouble();
        double b=sc.nextDouble();

        per=2*(l+b);

        System.out.println("Perimeter of trinagle is = "+ per);

    }
}
