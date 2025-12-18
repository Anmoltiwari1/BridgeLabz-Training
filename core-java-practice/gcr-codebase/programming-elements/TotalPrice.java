import java.util.Scanner;

public class TotalPrice {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double total=0;
        //taking the input
        System.out.println("Enter the price and quatity to be baught");
        double p=sc.nextInt();
        int q=sc.nextInt();

        //Calculating the total price
        total=p*q;

        System.out.println("The total purchase price is INR "+total+" if the quantity "+p+" and unit price is INR "+q);


    }   
}
