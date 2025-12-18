import java.util.Scanner;

public class SquarePerimeter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();

        int perimeter=0;

        perimeter=4*a;

        System.out.println("The lenght of the side is "+a+" whose perimeter is "+perimeter);
    }
}
