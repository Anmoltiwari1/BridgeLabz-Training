import java.util.Scanner;

public class ThreeFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Amar's age: ");
        int amarAge = scanner.nextInt();
        System.out.print("Enter Amar's height: ");
        double amarHeight = scanner.nextDouble();
        
        System.out.print("Enter Akbar's age: ");
        int akbarAge = scanner.nextInt();
        System.out.print("Enter Akbar's height: ");
        double akbarHeight = scanner.nextDouble();
        
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = scanner.nextInt();
        System.out.print("Enter Anthony's height: ");
        double anthonyHeight = scanner.nextDouble();
        
        String youngest = "Amar";
        int minAge = amarAge;
        if (akbarAge < minAge) {
            youngest = "Akbar";
            minAge = akbarAge;
        }
        if (anthonyAge < minAge) {
            youngest = "Anthony";
        }
        
        String tallest = "Amar";
        double maxHeight = amarHeight;
        if (akbarHeight > maxHeight) {
            tallest = "Akbar";
            maxHeight = akbarHeight;
        }
        if (anthonyHeight > maxHeight) {
            tallest = "Anthony";
        }
        
        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);
        
        scanner.close();
    }
}
