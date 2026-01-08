import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the values of array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the index");
        int index=sc.nextInt();
        System.out.println("Enter the value to be divided");
        int div=sc.nextInt();

        try {
            double res=arr[index]/div;
            System.out.println("Result is : "+res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }catch(ArithmeticException e){
            System.out.println("Cannot divide by zero!");
        }
    }
}
