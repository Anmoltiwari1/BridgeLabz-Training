import java.util.Scanner;

public class UnitConvertor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 for conversion from km to miles");
        System.out.println("Enter 2 for conversion from miles to km");
        System.out.println("Enter 3 for conversion from meter to feet");
        System.out.println("Enter 4 for conversion from feet to meter");
        int n=sc.nextInt();

        System.out.println("Enter the value to be converted");
        double value=sc.nextInt();

        double calculated=0;

        if(n==1){
           calculated=KimToMiles(n);
        }else if(n==2){
            calculated=MilesToKim(n);
        }else if(n==3){
            calculated=MetersToFeet(n);
        }else if(n==4){
            calculated=FeetToMeters(n);
        }
        System.out.println("The value you have give "+value+ " its converted to "+calculated);
    }

    public static double KimToMiles(int n){
        double conv=0;

        conv=n*0.621371;

        return conv;
    }
    public static double MilesToKim(int n){
        double conv=0;

        conv=n*1.60934;

        return conv;
    }
    public static double MetersToFeet(int n){
        double conv=0;

        conv=n*3.28084;

        return conv;
    }
    public static double FeetToMeters(int n){
        double conv=0;

        conv=n*0.3048;

        return conv;
    }
}
