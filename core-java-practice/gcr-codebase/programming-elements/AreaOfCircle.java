import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        double area=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the radius of circle");
        double r=sc.nextDouble();

        double pie=3.14;

        area=pie*(r*r);

        System.out.println("Area calculated = "+area);
    }
}
