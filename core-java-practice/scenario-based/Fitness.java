import java.util.Scanner;

public class Fitness {
    public static void main(String[] args) {
        double height=0,weight=0,bmi=0;
        Scanner sc=new Scanner(System.in);
        //Taking Height input in meters
        System.out.println("Enter Your Height in meters");
        height=sc.nextDouble();
        //Taking wieght input in kilograms
        System.out.println("Enter Your Weight in kilograms");
        weight=sc.nextDouble();

        if(height<1 || weight<1){
            System.out.println("Wrong input give, the correct Height and Weight");
            sc.close();
            return;
        }

        //Calculating BMI
        bmi=weight/(height*height);

        //Checking the user is in which category
        if(bmi<18.5){
            System.out.println("You are in Underweight Category");
        }
        else if(bmi>=18.5 && bmi<24.9){
            System.out.println("Your are in the Normal Category");
        }else{
             System.out.println("Your are in the Overweight Category");
        }

        sc.close();
    }
}
