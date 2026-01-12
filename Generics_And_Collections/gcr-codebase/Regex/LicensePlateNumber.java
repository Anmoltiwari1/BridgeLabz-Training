import java.util.Scanner;

public class LicensePlateNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the license plate number");
        String ls=sc.nextLine();

        if(check(ls))
            System.out.println("valid");
        else 
            System.out.println("invalid");

        sc.close();
    }

    public static boolean check(String ls){
        ls=ls.trim();

        if(ls.isEmpty()) return false;
        
        String regex="^[A-Z]{2}[0-9]{4}$";

        return ls.matches(regex);

    }
}
