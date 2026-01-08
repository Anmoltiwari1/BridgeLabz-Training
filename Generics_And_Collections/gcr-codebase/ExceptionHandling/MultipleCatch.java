import java.util.Scanner;

public class MultipleCatch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the values of array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the index");
        int index=sc.nextInt();

        try {
            System.out.println("Value at index "+index+" : " +arr[index]);
        } catch(NullPointerException e){
            System.out.println("Array is not initialized");
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        }

        sc.close();
    }
}
