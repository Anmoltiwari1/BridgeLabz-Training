import java.util.*;
public class Temp_Conversion {
    public static void main(String[] args)
    {
        double c=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the F value");
        double F=sc.nextDouble();

        
        c=(F-32)*(5/9);

        System.out.println("Converted value is:"+c);
    }
}
