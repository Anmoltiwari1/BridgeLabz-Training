import java.util.*;

public class LexcailTwist {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first word");
        String first = sc.nextLine();
        
        System.out.println("Enter the second word");
        String second = sc.nextLine();

        boolean check = checkReverse(first, second);

        if (check) {
            firstCase(first);
        } else {
            secondcase(first, second);
        }

        sc.close();
    }

    public static boolean checkReverse(String first, String second) {
        if (first.length() != second.length())
            return false;

        String r = reverseString(first);
        return second.equalsIgnoreCase(r);
    }

    public static String reverseString(String s) {
        String r = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            r = r + s.charAt(i);
        }
        return r;
    }

    public static void firstCase(String first) {

        first = reverseString(first).toLowerCase();
        String s = "";

        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);
            if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                s = s + '@';
            } else {
                s = s + ch;
            }
        }
        System.out.println(s);
    }

    public static void secondcase(String first, String second) {
        first = (first + second).toUpperCase();

        int v = 0, c = 0;

        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);

            if (Character.isLetter(ch)) {
                if (ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
                    v++;
                } else {
                    c++;
                }
            }
        }

        if (v > c) {
            printvowel(first);
        } else if (c > v) {
            printconst(first);
        } else {
            System.out.println("Vowels and consonants are equal");
        }
    }

    public static void printvowel(String s) {
        Set<Character> seen = new HashSet<>();
        int count = 0;

        for (int i = 0; i < s.length() && count < 2; i++) {
            char ch = s.charAt(i);
            if ((ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') && seen.add(ch)) {
                System.out.println(ch);
                count++;
            }
        }
    }

    public static void printconst(String s) {
        Set<Character> seen = new HashSet<>();
        int count = 0;

        for (int i = 0; i < s.length() && count < 2; i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch) &&
                ch!='A' && ch!='E' && ch!='I' && ch!='O' && ch!='U' &&
                seen.add(ch)) {

                System.out.println(ch);
                count++;
            }
        }
    }
}
