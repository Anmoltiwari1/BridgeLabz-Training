package Level1;
import java.util.Scanner;

public class PowerCalculation {
    public static void main(String[] args) {
        double res=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of base and exponent");
        int x=sc.nextInt();
        int p=sc.nextInt();

        res=Math.pow(x, p);
        System.out.println("Power calculation of given numbers = "+ res);
        sc.close();
    }
}
