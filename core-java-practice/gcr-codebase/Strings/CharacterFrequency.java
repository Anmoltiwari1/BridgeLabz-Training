package String.Level3;

import java.util.Scanner;

public class CharacterFrequency {

    public static int findLength(String text) {
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return length;
    }

    public static String[][] findFrequencies(String text) {
        int[] freq = new int[256]; 
        int len = findLength(text);

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        boolean[] visited = new boolean[256];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (!visited[ch]) {
                visited[ch] = true;
                uniqueCount++;
            }
        }

        String[][] result = new String[uniqueCount][2];
        boolean[] added = new boolean[256];
        int index = 0;

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (!added[ch]) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                added[ch] = true;
                index++;
            }
        }

        return result;
    }

    public static void displayResult(String[][] result) {
        System.out.printf("%-10s %-10s\n", "Character", "Frequency");
        System.out.println("------------------------");
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-10s %-10s\n", result[i][0], result[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[][] frequencies = findFrequencies(input);
        displayResult(frequencies);
    }
}

