package String.Level1;

import java.util.Scanner;

public class LowercaseDemo {
    public static String toLower(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String manual = toLower(text);
        String builtin = text.toLowerCase();
        System.out.println("Manual: " + manual);
        System.out.println("Built-in: " + builtin);
        System.out.println("Are equal: " + compareStrings(manual, builtin));
    }
}