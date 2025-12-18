import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number to be checked");
        int n = sc.nextInt();

        int num = 0;

        while (n != 0) {
            int d = n % 10;
            num = num * 10 + d;
            n = n / 10;
        }

        System.out.println(num);
    }
}
