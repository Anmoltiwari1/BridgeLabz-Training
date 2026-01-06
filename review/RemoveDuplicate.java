package review;
import java.util.*;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=sc.nextLine();
        int n=str.length();

        System.out.println("String before removing duplicates");
        System.out.println(str);
        System.out.println("String after removing duplicates from it");
        str=remove(str,n);
        System.out.println(str);

    }

    public static String remove(String str,int n){
        HashSet<Character> h=new HashSet<>();
        String res="";

        for(int i=0;i<n;i++){
            char c=str.charAt(i);
            if(!h.contains(c)){
                res+=c;
                h.add(c);
            }
        }

        return res;
    }
}
