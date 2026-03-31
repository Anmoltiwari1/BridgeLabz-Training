import java.util.Scanner;

class InvalidAgeException extends Exception{


    InvalidAgeException(String message){
        super(message);
    }
}

public class CustomException {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the age");
        int age=sc.nextInt();

        try {
            validateAge(age);
            System.out.println("Age is valid");
        } catch (InvalidAgeException e) {
           System.out.println(e.getMessage());
        }

        sc.close();
    }

    public static void validateAge(int age) throws InvalidAgeException{

        if(age<18){
            throw new InvalidAgeException("Age is less than 18");
        }
    }
}
