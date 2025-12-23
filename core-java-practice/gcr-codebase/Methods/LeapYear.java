import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the year");
        int n=sc.nextInt();

        boolean check=CheckLeapYear(n);

        if (check) {
            System.out.println("This is a leap Year");
        } else {
            System.out.println("This is not a leap Year");
        }
        sc.close();
    }

    public static boolean CheckLeapYear(int n){

        if(n<=1582){
            return false;
        }
        else if(n%4==0 && n%100!=0 && n%400==0){
            return true;
        }
        else{
            return false;
        }
    }
}
