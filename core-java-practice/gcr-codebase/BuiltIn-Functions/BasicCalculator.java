import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = sc.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = sc.nextInt();
        System.out.println("Enter the operator (+, -, *, /): ");
        String operator = sc.next();
        System.out.println("Result: " + calculate(num1, num2, operator));
        sc.close();
    }

    private static String calculate(int num1, int num2, String operator) {
        if (operator.equals("+")) {
            return String.valueOf(num1 + num2);
        } else if (operator.equals("-")) {
            return String.valueOf(num1 - num2);
        } else if (operator.equals("*")) {
            return String.valueOf(num1 * num2);
        } else if (operator.equals("/")) {
            if (num2 != 0) {
                return String.valueOf(num1 / num2);
            } else {
                return "Error: Division by zero is not allowed";
            }
        } else {
            return "Error: Invalid operator";
        }
    }
}
