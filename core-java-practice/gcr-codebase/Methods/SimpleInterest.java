import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Principle,Rate and Time");
        double p=sc.nextInt();
        double r=sc.nextInt();
        double t=sc.nextInt();

        double si=SI(p, r, t);

        System.out.println("The Simple Intrest is "+ si + "for Principle "+p +", Rate if Interest "+r+ "and Time "+ t);

        sc.close();
    }

    public static double SI(double p,double r,double t)
    {
        double si=0;

        si=p*r*t/100;

        return si;
    }
}

