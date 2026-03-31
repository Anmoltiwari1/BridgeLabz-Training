package Level2;

import java.util.Scanner;

public class OperationDouble {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int op1=0,op2=0,op3=0,op4=0;
        System.out.println("Enter the value a,b,c");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();

        op1=a+b*c;
        op2=a*b+c;
        op3=c+a/b;
        op4=a%b+c;

        System.out.println("The result of the operations are "+op1+","+op2+","+op3+" and "+op4);

        sc.close();
    }
}
