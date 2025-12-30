import java.util.Scanner;

public class StockSpan {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of days: ");
        int n=sc.nextInt();
        int[] price=new int[n];
        int[] span=new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter the price of day "+(i+1)+": ");
            price[i]=sc.nextInt();
        }

        span=span(price, n);

        for(int i=0;i<n;i++){
            System.out.println("Span of day "+(i+1)+" is: "+span[i]);
        }
    }

    public static int[] span(int[] price,int n){

        int[] span=new int[n];
        int count=1;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(price[i]>=price[j]){
                    count++;
                }else{
                    count=1;
                    break;
                }
            }
            span[i]=count;
            count=1;
        }
        return span;
    }
}
