
import java.util.Scanner;

public class FindStringLengthWithoutLengthMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int length1 = getLength(input);
        int length2 = input.length();
        System.out.println("User-defined length: " + length1);
        System.out.println("Built-in length: " + length2);
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
}
