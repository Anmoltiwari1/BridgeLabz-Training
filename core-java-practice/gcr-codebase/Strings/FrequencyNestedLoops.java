package String.Level3;
import java.util.Scanner;

public class FrequencyNestedLoops {

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

    public static String[] findFrequencies(String text) {
        char[] chars = text.toCharArray();
        int len = findLength(text);
        int[] freq = new int[len];

        for (int i = 0; i < len; i++) {
            freq[i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j] && chars[i] != '0') {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " = " + freq[i];
                index++;
            }
        }

        return result;
    }

    public static void displayResult(String[] result) {
        System.out.println("Character Frequencies:");
        for (String entry : result) {
            System.out.println(entry);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[] frequencies = findFrequencies(input);
        displayResult(frequencies);
    }
}