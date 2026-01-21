import java.util.Scanner;

public class SlidingWindow {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the size of window");
        int k=sc.nextInt();

        int[] res=new int[n-k+1];
        res=max(arr, n, k);

        for(int i=0;i<n-k+1;i++)
            System.out.println(res[i]);
    }
    public static int[] max(int[] arr,int n,int k){
        int[] res=new int[n-k+1];
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<=n-k;i++)
        {
            for(int j=i;j<=((i+k)-1);j++){
                max=Math.max(max,arr[j]);
            }
            res[count++]=max;
            max=Integer.MIN_VALUE;
        }
        return res;
    }
}
