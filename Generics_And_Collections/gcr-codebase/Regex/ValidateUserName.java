import java.util.Scanner;

public class ValidateUserName {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the username");
        String username=sc.nextLine();
        if(check(username)){
            System.out.println("Valid username");
        }else{
            System.out.println("Invalid username");
        }
        sc.close();
    }

    public static boolean check(String username){
        username=username.trim();
        if(username.isEmpty())
            return false;

        String regex="^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        return username.matches(regex);

    }
}
