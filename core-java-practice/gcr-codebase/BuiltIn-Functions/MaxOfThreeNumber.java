import java.util.Scanner;

public class MaxOfThreeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNum = sc.nextInt();
        int secondNum = sc.nextInt();
        int thirdNum = sc.nextInt();

        int max = maxOfThreeNumber(firstNum, secondNum, thirdNum);
        System.out.println("The maximum number is: " + max);
    }

    private static int maxOfThreeNumber(int firstNum, int secondNum, int thirdNum) {
        int max = firstNum;
        if (secondNum > max) {
            max = secondNum;
        }
        if (thirdNum > max) {
            max = thirdNum;
        }
        return max;
    }
}