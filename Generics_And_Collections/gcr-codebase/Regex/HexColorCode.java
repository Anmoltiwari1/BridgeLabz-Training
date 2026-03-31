import java.util.Scanner;

public class HexColorCode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Hex color Code");
        String hex=sc.nextLine();

        if(check(hex)){
            System.out.println("Valid");
        }else{
            System.out.println("Not valid");
        }

    }

    public static boolean check(String hex){
        hex=hex.trim();

        if(hex.isEmpty()) return false;

        String regex="^#[0-9A-Fa-f]{6}$";

        return hex.matches(regex);
    }
}
