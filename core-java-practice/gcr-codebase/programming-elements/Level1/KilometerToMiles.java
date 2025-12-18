package Level1;
import java.util.Scanner;

public class KilometerToMiles {
    public static void main(String[] args) {
        double conv=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of kilometer");
        int km=sc.nextInt();

        conv=km*0.621371;

        System.out.println("Converted value is = "+ conv);
    }
}
