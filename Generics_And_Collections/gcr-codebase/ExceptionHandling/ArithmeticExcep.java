import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticExcep {
    public static void main(String[] args) {
        
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the 2 numbers");
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=a/b;
            System.out.println(c);
        } catch(InputMismatchException e){
            System.out.println("InputMismatchException");
        }catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
            
        }

    }
}
