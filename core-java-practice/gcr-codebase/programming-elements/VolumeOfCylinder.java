import java.util.Scanner;

public class VolumeOfCylinder {
    public static void main(String[] args) {
        double volume=0,pie=3.14;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the vakue of r");
        double r=sc.nextDouble();
        System.out.println("Enter the vakue of h");
        double h=sc.nextDouble();

        volume=pie*(r*r)*h;

        System.out.println("Volume of cylinder is = "+ volume);
        
    }
}
