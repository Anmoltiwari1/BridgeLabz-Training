package Level2;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the 2 numbers");
        double a=sc.nextDouble();
        double b=sc.nextDouble();

        double add=0,sub=0,mul=0,div=0;

        add=a+b;
        sub=a-b;
        mul=a*b;
        div=a/b;

        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+a+" and "+b+" is "+add+ ","+sub+","+mul+"and"+div);

    }
}

}
