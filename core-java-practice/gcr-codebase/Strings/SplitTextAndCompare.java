
import java.util.Scanner;

public class SplitTextAndCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] userWords = splitText(input);
        String[] builtInWords = input.split(" ");
        boolean result = compare(userWords, builtInWords);
        System.out.println("User-defined split:");
        for (String word : userWords) System.out.println(word);
        System.out.println("Built-in split:");
        for (String word : builtInWords) System.out.println(word);
        System.out.println("Are both arrays equal? " + result);
    }

    public static String[] splitText(String text) {
        int count = 1;
        for (int i = 0;; i++) {
            try {
                if (text.charAt(i) == ' ') count++;
            } catch (Exception e) {
                break;
            }
        }
        String[] words = new String[count];
        int start = 0, idx = 0;
        for (int i = 0;; i++) {
            try {
                if (text.charAt(i) == ' ') {
                    words[idx++] = getSubstring(text, start, i);
                    start = i + 1;
                }
            } catch (Exception e) {
                words[idx] = getSubstring(text, start, i);
                break;
            }
        }
        return words;
    }

    public static String getSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) result += text.charAt(i);
        return result;
    }

    public static boolean compare(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }
}
