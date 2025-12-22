import java.util.Scanner;

public class WindChill {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Temprature");
        int t=sc.nextInt();
        System.out.println("Enter the windSpeed");
        int w=sc.nextInt();

        double res=calculateWindChill(t, w);

        System.out.println("Wind chill is = "+res);
        sc.close();
    }

    public static double calculateWindChill(int t,int w){
        double calc=0;

        calc=35.74+ 0.6215*t + (0.4275 * t - 35.75)*w;

        return calc;
    }
}
