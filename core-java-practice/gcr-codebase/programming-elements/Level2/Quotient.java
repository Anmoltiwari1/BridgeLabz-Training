package Level2;

import java.util.Scanner;

public class Quotient {
    public static void main(String[] args) {
        double Rem=0,Qou=0;
        Scanner sc=new Scanner(System.in);
        int num1=sc.nextInt();
        int num2=sc.nextInt();

        Rem=num1/num2;
        Qou=num1%num2;

        System.out.println("The Quotient is "+Qou+" and the Reminder is "+Rem+" of two number is "+ num1 +" and "+ num2);
        sc.close();
    }
}
