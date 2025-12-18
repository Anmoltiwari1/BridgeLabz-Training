package Level1;
import java.util.Scanner;

public class Average_of_three {
    public static void main(String[] args) {
        double avg=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the 3 numbers");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();

        avg=(a+b+c)/3;

        System.out.println("Average of given numbers are = "+avg);
    }
}
