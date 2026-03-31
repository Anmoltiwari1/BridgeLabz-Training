import java.util.Scanner;

public class SpringSeason{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Month");
        String Month=sc.nextLine();

        System.out.println("Enter date");
        int Day=sc.nextInt();

        boolean c=check(Month, Day);

        if(c==true){
            System.out.println("Its a Spring Season");
        }else{
            System.out.println("Not a Spring Season");
        }
        sc.close();
    }

    public static boolean check(String m,int d){

        if(m=="March"){
            if(d>=20){
                return true;
            }
        }
        if(m=="April"){
            return true;
        }
        if(m=="May"){
            return true;
        }
        if(m=="June"){
            if(d<=20)
                return true;
        }

        return false;

    }
}