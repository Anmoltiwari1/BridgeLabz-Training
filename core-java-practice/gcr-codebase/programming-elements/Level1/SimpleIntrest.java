package Level1;
import java.util.*;
public class SimpleIntrest {
    public static void main(String[] args) {
        double SI=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of p,r,t");
        double p=sc.nextInt();
        double r=sc.nextInt();
        double t=sc.nextInt();

        SI=(p*r*t)/100;

        System.out.println("Vlaue of Simple Intrest = "+SI);

    }
}
