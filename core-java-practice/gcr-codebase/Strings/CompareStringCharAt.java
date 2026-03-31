package String.Level1;

import java.util.*;

public class CompareStringCharAt {

    public static boolean compareCharByChar(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i)) return false;
        return true;
    }

    public static void compareStrings() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        boolean result1 = compareCharByChar(s1, s2);
        boolean result2 = s1.equals(s2);
        System.out.println("CharByChar: " + result1);
        System.out.println("Built-in equals(): " + result2);
    }
}
