import java.util.Scanner;

public class GCD_LCM_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        int gcd = findGCD(firstNumber, secondNumber);
        int lcm = findLCM(firstNumber, secondNumber);
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
        sc.close();
    }

    private static int findLCM(int firstNumber, int secondNumber) {
        return (firstNumber * secondNumber) / findGCD(firstNumber, secondNumber);
    }

    private static int findGCD(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        } else {
            return findGCD(secondNumber, firstNumber % secondNumber);
        }
    }
}