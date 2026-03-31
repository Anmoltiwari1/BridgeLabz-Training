import java.util.*;

public class FactorsFunction {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=sc.nextInt();

        int s=0,product=0,power=0;

        s=sum(n);
        power=sumofSquares(n);
        product=ProductofSquares(n);

        System.out.println("Sum is "+sum+"Product is "+product+"sum of square of factors is "+power);
        sc.close();
    }

    public static ArrayList<Integer> factors(int n){
        ArrayList<Integer> al=new ArrayList<>();

        for(int i=1;i<n;i++){
            if(n%i==0){
                al.add(i);
            }
        }

        return al;
    }

    public static int sum(int n){
        ArrayList<Integer> al=new ArrayList<>();
        int sum=0;

        al=factors(n);

        for(int i=0;i<al.size();i++){
            sum+=al.get(i);
        }

        return sum;
    }
    public static int sumofSquares(int n){
        ArrayList<Integer> al=new ArrayList<>();
        int sum=0;

        al=factors(n);

        for(int i=0;i<al.size();i++){
            sum+=Math.pow(al.get(i),2);
        }

        return sum;
    }
    public static int ProductofSquares(int n){
        ArrayList<Integer> al=new ArrayList<>();
        int p=1;

        al=factors(n);

        for(int i=0;i<al.size();i++){
            p*=al.get(i);
        }

        return p;
    }
}
