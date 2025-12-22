
public class StringTrim {

    public static int[] findTrimIndices(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end + 1};
    }

    public static String createSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "   Hello World!   ";
        int[] indices = findTrimIndices(input);
        String trimmed = createSubstring(input, indices[0], indices[1]);
        boolean isEqual = compareStrings(trimmed, input.trim());
        System.out.println("Trimmed using method: '" + trimmed + "'");
        System.out.println("Trimmed using built-in: '" + input.trim() + "'");
        System.out.println("Are both equal: " + isEqual);
    }
}
