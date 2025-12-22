
import java.util.Scanner;

public class SplitTextWithWordLengths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = splitText(input);
        String[][] wordLengths = getWordLengths(words);
        System.out.println("Word\tLength");
        for (String[] row : wordLengths) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }
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

    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }
}
