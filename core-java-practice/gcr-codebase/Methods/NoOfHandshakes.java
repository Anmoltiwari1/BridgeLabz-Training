import java.util.Scanner;

public class NoOfHandshakes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of students");
        int n=sc.nextInt();

        int h=0;
        
        h=numberOfhand(n);

        System.out.println("Number of possible handhsake "+h);

        sc.close();
    }

    public static int numberOfhand(int n)
    {
        int h=0;

        h=(n*(n-1))/2;

        return h;
    }
}
