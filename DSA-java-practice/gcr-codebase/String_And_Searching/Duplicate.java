import java.util.HashSet;
import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String to be reversed");
        String str=sc.nextLine();

        System.out.println(removeDuplicates(str));
        sc.close();
    }

    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for(char c:str.toCharArray()){
            if(!set.contains(c)){
                sb.append(c);
                set.add(c);
            }
        }

        return sb.toString();
    }
}
