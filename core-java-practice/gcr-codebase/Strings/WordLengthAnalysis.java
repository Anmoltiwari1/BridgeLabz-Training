import java.util.*;

public class WordLengthAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitText(text);
        String[][] wordWithLengths = getWordLengths(words);
        int[] indices = getShortestAndLongest(wordWithLengths);
        System.out.println("Shortest word: " + wordWithLengths[indices[0]][0]);
        System.out.println("Longest word: " + wordWithLengths[indices[1]][0]);
    }

    static String[] splitText(String text) {
        int count = 1;
        for (int i = 0; ; i++) {
            try {
                if (text.charAt(i) == ' ') count++;
            } catch (Exception e) {
                break;
            }
        }
        String[] words = new String[count];
        int start = 0, wordIndex = 0;
        for (int i = 0; ; i++) {
            try {
                if (text.charAt(i) == ' ') {
                    words[wordIndex++] = extractSubstring(text, start, i);
                    start = i + 1;
                }
            } catch (Exception e) {
                words[wordIndex] = extractSubstring(text, start, i);
                break;
            }
        }
        return words;
    }

    static String extractSubstring(String s, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) result += s.charAt(i);
        return result;
    }

    static int getLength(String word) {
        int count = 0;
        for (;;) {
            try {
                word.charAt(count);
                count++;
            } catch (Exception e) {
                break;
            }
        }
        return count;
    }

    static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    static int[] getShortestAndLongest(String[][] wordWithLengths) {
        int minIndex = 0, maxIndex = 0;
        for (int i = 1; i < wordWithLengths.length; i++) {
            int len = Integer.parseInt(wordWithLengths[i][1]);
            int minLen = Integer.parseInt(wordWithLengths[minIndex][1]);
            int maxLen = Integer.parseInt(wordWithLengths[maxIndex][1]);
            if (len < minLen) minIndex = i;
            if (len > maxLen) maxIndex = i;
        }
        return new int[]{minIndex, maxIndex};
    }
}