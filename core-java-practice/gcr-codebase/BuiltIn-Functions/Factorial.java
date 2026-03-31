import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        System.out.println("factorial of " + number + " is " + factorial(number));
        sc.close();
    }

    private static int factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return (number * factorial(number - 1));
        }
    }

}