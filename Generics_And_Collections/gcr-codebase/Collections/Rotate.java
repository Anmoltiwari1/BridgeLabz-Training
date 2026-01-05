import java.util.Scanner;
public class Rotate {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the array elements");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the number of rotations");
        int k=sc.nextInt();

        System.out.println("Array before rotation");
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }

        arr=rotate(arr, n, k);

        System.out.println("Array after roatation");
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
    }
    public static int[] rotate(int[] arr,int n,int k){

        int[] temp=new int[k];
        for(int i=0;i<k;i++){
            temp[i]=arr[i];
        }
        for(int i=k;i<n;i++){
            arr[i-k]=arr[i];
        }
        int j=0;
        for(int i=n-k;i<n;i++){
            arr[i]=temp[j];
            j++;
        }

        return arr;
    }
}
