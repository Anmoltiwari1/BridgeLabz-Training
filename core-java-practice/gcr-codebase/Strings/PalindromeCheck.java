package String.Level3;
import java.util.Scanner;

public class PalindromeCheck {

    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = findLength(text) - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static boolean isPalindromeUsingReverse(String text) {
        int len = findLength(text);
        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < len; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    public static char[] reverseString(String text) {
        int len = findLength(text);
        char[] reversed = new char[len];
        for (int i = 0; i < len; i++) {
            reversed[i] = text.charAt(len - 1 - i);
        }
        return reversed;
    }

    public static int findLength(String text) {
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return length;
    }

    public static void displayResult(String text) {
        System.out.println("Checking palindrome for: " + text);

        boolean logic1 = isPalindromeIterative(text);
        System.out.println("Logic 1 - Iterative: " + (logic1 ? "Palindrome" : "Not Palindrome"));

        boolean logic2 = isPalindromeRecursive(text, 0, findLength(text) - 1);
        System.out.println("Logic 2 - Recursive: " + (logic2 ? "Palindrome" : "Not Palindrome"));

        boolean logic3 = isPalindromeUsingReverse(text);
        System.out.println("Logic 3 - Using Reverse Array: " + (logic3 ? "Palindrome" : "Not Palindrome"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to check palindrome: ");
        String input = scanner.nextLine();

        displayResult(input);
    }
}
