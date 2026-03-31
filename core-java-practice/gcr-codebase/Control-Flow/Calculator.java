import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double first;
        double second;
        String op;
        
        System.out.print("Enter first number: ");
        first = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        second = scanner.nextDouble();
        
        System.out.print("Enter operator (+, -, *, /): ");
        op = scanner.next();
        
        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                if (second != 0) {
                    System.out.println("Result: " + (first / second));
                } else {
                    System.out.println("Error: Division by zero is not allowed");
                }
                break;
            default:
                System.out.println("Invalid Operator");
                break;
        }
        
        scanner.close();
    }
}
