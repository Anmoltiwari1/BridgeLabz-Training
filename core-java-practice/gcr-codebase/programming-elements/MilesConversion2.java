import java.util.Scanner;
public class MilesConversion2 {
    public static void main(String[] args) {
        double conv=0;
        Scanner sc=new Scanner(System.in);
       //Inisilizing the value
        double km=10.8;

        //Converting the value
        conv=km*0.621371;

        //Printing the value
        System.out.println("Converted value is = "+ conv);
    }
}

}
