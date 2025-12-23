import java.util.Scanner;

public class FibGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        fibGenerator(number);
        sc.close();
    }

    private static void fibGenerator(int number) {
        int a = 0, b = 1;
        System.out.println("Fibonacci sequence up to " + number + " is:");
        for (int i = 0; i <= number; i++) {
            System.out.print(a + " ");
            int temp = a;
            a = b;
            b = temp + b;
        }
        System.out.println();
    }
}